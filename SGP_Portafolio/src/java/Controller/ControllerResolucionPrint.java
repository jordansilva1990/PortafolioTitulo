package Controller;

import Model.Resoluciones;
import Model.ResolucionesDetalle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@WebServlet(name = "ControllerResolucionPrint", urlPatterns = {"/ControllerResolucionPrint"})
public class ControllerResolucionPrint extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Se inicializan variables necesarias para trabajar
        HttpSession session = request.getSession();
        Logger logger = Logger.getAnonymousLogger();
        Map<String, String> mapMensajes = new HashMap<>();

        //Se crean variables para recuperar los permisos de la BD
        DAO.ResolucionDetalleDAO resoluDetalleDAO = new DAO.ResolucionDetalleDAO();
        DAO.ResolucionDAO resoluDAO = new DAO.ResolucionDAO();

        //Se recupera el id del permiso a imprimir
        String idPer = request.getParameter("id");
//       if (idPer.isEmpty()) {
        System.out.println(idPer);
//            mapMensajes.put("ID", "ID  no valido");
//        }
//  
        List<Resoluciones> resolu = resoluDAO.find(idPer);
        List<ResolucionesDetalle> resoluDeta = resoluDetalleDAO.findById(idPer);
        //se setea coom atributo para luego rescatarlo desde jsp
        request.setAttribute("ResolucionesDetalle", resoluDeta);
        System.out.println(resolu.get(0).getIdResolucion());
        request.setAttribute("Resoluciones", resolu);
        request.getRequestDispatcher("/PDFResoluciones.jsp").forward(request, response);
        //Luego de verificar la inexistencia de problemas se realiza la consulta para obtener el permiso y redirigirlo para su impresion
//        if (mapMensajes.isEmpty()) {
//        try {
//            //se rescata el permiso especifico
//            List<Resoluciones> resolu = resoluDAO.findById(idPer);
//            List<ResolucionesDetalle> resoluDeta = resoluDetalleDAO.findById(idPer);
//            //se setea coom atributo para luego rescatarlo desde jsp
//            //request.setAttribute("ResolucionesDetalle", resolu);
//            System.out.println(resoluDeta.get(0).getRecursolegalafecto());
//            request.setAttribute("Resoluciones", resoluDeta);
//            request.getRequestDispatcher("/PDFResoluciones.jsp").forward(request, response);
//        } catch (Exception e) {
//            request.getRequestDispatcher("/ControllerNuevaResolucion").forward(request, response);
//        }
    }
}
