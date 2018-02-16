/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PermisosDetalleDAO;
import DAO.ResolucionDAO;
import DAO.ResolucionDetalleDAO;
import DAO.UnidadesDAO;
import Model.PermisosDetalles;
import Model.Resoluciones;
import Model.ResolucionesDetalle;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jonathan
 */
@WebServlet(name = "ControllerAgregarResolucion", urlPatterns = {"/ControllerAgregarResolucion"})
public class ControllerAgregarResolucion extends HttpServlet {

    List<PermisosDetalles> permisos;
    List<PermisosDetalles> permisos2;
    String mes;
    String depto;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UnidadesDAO uniDAO = new UnidadesDAO();
            DAO.PermisosDetalleDAO detalleDAO = new DAO.PermisosDetalleDAO();
            request.setAttribute("unidades", uniDAO.findAll());
            request.setAttribute("permisos", detalleDAO.findAll());
        } catch (Exception e) {
        }
        request.getRequestDispatcher("/AgregarResolucion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Variables Necesarias
        Logger logger = Logger.getAnonymousLogger();
        HttpSession session = request.getSession();
        Map<String, String> mapMensajes = new HashMap<>();

        //Se crean variables para recuperar los permisos de la BD
        DAO.PermisosDetalleDAO detalleDAO = new DAO.PermisosDetalleDAO();
        mes = request.getParameter("mes");
        depto = request.getParameter("depto");
        System.out.println(mes);
        System.out.println(depto);
        String action = request.getParameter("accion");
        if ((mes.equalsIgnoreCase("0")) || (depto.equalsIgnoreCase("seleccione"))) {
            System.out.println("No pasó");
            doGet(request, response);
        } else {
            if (action.equalsIgnoreCase("consultar")) {
                System.out.println(mes);
                if (mes.isEmpty()) {
                    mapMensajes.put("Mes", "Mes no valido");
                }
                System.out.println(depto);
                if (depto.isEmpty()) {
                    mapMensajes.put("Depto", "Departamento no valido");
                }
                permisos = detalleDAO.findAllByUserDeptoDate(depto, mes);
                permisos2 = new ArrayList<PermisosDetalles>();
                try {
                    UnidadesDAO uniDAO = new UnidadesDAO();
                    request.setAttribute("unidades", uniDAO.findAll());
                    System.out.println(permisos.size());
                    for (int i = 0; i < permisos.size(); i++) {
                        if (permisos.get(i).getUsuarios().getUnidades().getNombreunidad().equalsIgnoreCase(depto)) {
                            permisos2.add(permisos.get(i));
                            System.out.println(permisos.get(i).getUsuarios().getUnidades().getNombreunidad());
                        } else {
                            System.out.println("no existe");
                        }
                    }
                    request.setAttribute("permisos", permisos2);
                    request.getRequestDispatcher("/AgregarResolucion.jsp").forward(request, response);
                } catch (Exception e) {
                    request.setAttribute("permisos", permisos2);
                    request.getRequestDispatcher("/AgregarResolucion.jsp").forward(request, response);
                }
            } else {
                Resoluciones resoluciones = new Resoluciones();
                ResolucionDAO resolucionDAO = new ResolucionDAO();
                resoluciones.setResolucion("Resolución emitida para la unidad " + depto + (", con fecha ") + mes);
                resolucionDAO.ingresarSP(resoluciones);

                List<Resoluciones> lst = resolucionDAO.findLast();
                lst.stream().map((res) -> {
                    resoluciones.setIdResolucion(res.getIdResolucion());
                    return res;
                }).forEachOrdered((res) -> {
                    resoluciones.setResolucion(res.getResolucion());
                });

                ResolucionDetalleDAO resDetDAO = new ResolucionDetalleDAO();

                for (PermisosDetalles perDet : permisos) {

                    ResolucionesDetalle resDet = new ResolucionesDetalle();

                    resDet.setJustificacion(perDet.getMotivo());
                    resDet.setRecursolegalafecto(BigDecimal.ZERO);
                    resDet.setPermisos(perDet.getPermisos());
                    resDet.setResoluciones(resoluciones);

                    String idResolucion = javax.xml.bind.DatatypeConverter.printHexBinary(resoluciones.getIdResolucion());
                    String idPermiso = javax.xml.bind.DatatypeConverter.printHexBinary(resDet.getPermisos().getIdPermiso());

                    resDetDAO.ingresarSP(resDet, idResolucion, idPermiso);

                }
                doGet(request, response);
            }
        }
    }
}
