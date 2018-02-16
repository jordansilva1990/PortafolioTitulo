package Controller;

import DAO.PermisosDAO;
import DAO.PermisosDetalleDAO;
import DAO.TiposPermisosDAO;
import Model.Permisos;
import Model.PermisosDetalles;
import Model.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
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
 * @author Jordan Silva
 */
@WebServlet(name = "ControllerNuevaSolicitud", urlPatterns = {"/ControllerNuevaSolicitud"})
public class ControllerNuevaSolicitud extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            TiposPermisosDAO tipoPerDAO = new TiposPermisosDAO();
            request.setAttribute("tipos", tipoPerDAO.findAll());
        } catch (Exception e) {
        }
        request.getRequestDispatcher("/NuevaSolicitud.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Se crean variables necesarias para trabajar
        HttpSession session = request.getSession();
        Logger logger = Logger.getAnonymousLogger();
        Map<String, String> mapMensajes = new HashMap<>();
        PermisosDetalles perDet = new PermisosDetalles();

        Permisos per = new Permisos();
        PermisosDAO perDAO = new PermisosDAO();
        PermisosDetalleDAO perDetDAO = new PermisosDetalleDAO();

        //Se obtiene variable desde input para setear al objeto
        String motivo = request.getParameter("motivo");
        if (motivo.isEmpty()) {
            mapMensajes.put("Tipo", "Debe Ingresar Tipo de permiso");
        } else {
            perDet.setMotivo(motivo);
        }

        String tipoStr = request.getParameter("tipo");
        if (tipoStr.isEmpty()) {
            mapMensajes.put("Seleccione Tipo", "Debe Selecciona un tipo de permiso");
        }

        perDet.setDias(new BigDecimal(1));

        //Fecha Inicio - Detalle
        String startDateStr = request.getParameter("inicio");
        System.out.println(startDateStr);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = new Date();
        try {
            startDate = sdf.parse(startDateStr);

        } catch (ParseException ex) {
            Logger.getLogger(ControllerNuevaSolicitud.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (startDate != null) {
            perDet.setFechainicio(startDate);

        } else {
            mapMensajes.put("Inicio", "Debe Seleccionar fecha de inicio!!");
        }

        //Fecha de termino - Detalle
        String endDateStr = request.getParameter("fin");
        System.out.println(endDateStr);
        Date endDate = new Date();
        try {
            endDate = sdf.parse(endDateStr);
            System.out.println(endDate);
        } catch (ParseException ex) {
            Logger.getLogger(ControllerNuevaSolicitud.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (endDate != null) {
            perDet.setFechafin(endDate);
            System.out.println(endDate);
        } else {
            mapMensajes.put("Fin", "Debe Seleccionar fecha de Termino!!");
        }

        //Dias - Detalle
        long difference = (startDate.getTime() - endDate.getTime()) / 86400000;
        long dias = Math.abs(difference);
        perDet.setDias(new BigDecimal(dias).add(BigDecimal.ONE));

        //Se recupera la variable de sesion del usuario para obtener su ID mas adelante
        Usuarios user = (Usuarios) session.getAttribute("usuarioActivo");
        //Se Setea de manera predefinida como 1 (Pendiente)
        perDet.setEstado(new BigDecimal(1));

        //Luego de recuperar  y validar los datos necesarios se procede a intentar el ingreso del objeto a BD
        try {
            if (mapMensajes.size() == 0) {

                //Se realiza el ingreso del permiso
                perDAO.ingresarSP(per, user.getIdUsuario(), tipoStr);

                //Se rescata el id generado en la Base de Datos
                List<Permisos> perLst = perDAO.findLast();
                for (Permisos permi : perLst) {
                    per.setIdPermiso(permi.getIdPermiso());
                    System.out.println(javax.xml.bind.DatatypeConverter.printHexBinary(permi.getIdPermiso()));
                }

                //Parse de byte[] a String
                String idPermiso = javax.xml.bind.DatatypeConverter.printHexBinary(per.getIdPermiso());

                //Se realiza el ingreso del detalle correspondiente al permiso anteriormente ingresado
                perDetDAO.ingresarSP(perDet, user.getIdUsuario(), idPermiso);

                session.setAttribute("EstadoSolicitud", "Permiso creado correctamente");
            }

        } catch (Exception e) {
            session.setAttribute("EstadoSolicitud", "El permiso no logro ser creado, Reintente");
            logger.log(Level.SEVERE, "Problemas al ingresar Permiso", e);
        } finally {
            doGet(request, response);
        }

    }

}
