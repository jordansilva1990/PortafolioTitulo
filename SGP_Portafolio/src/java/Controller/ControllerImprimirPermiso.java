package Controller;

import Model.PermisosDetalles;
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
 * @author Jordan Silva
 */
@WebServlet(name = "ControllerImprimirPermiso", urlPatterns = {"/ControllerImprimirPermiso"})
public class ControllerImprimirPermiso extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Se inicializan variables necesarias para trabajar
        HttpSession session = request.getSession();
        Logger logger = Logger.getAnonymousLogger();
        Map<String, String> mapMensajes = new HashMap<>();
        

        //Se crean variables para recuperar los permisos de la BD
        DAO.PermisosDetalleDAO detalleDAO = new DAO.PermisosDetalleDAO();

        //Se recupera el id del permiso a imprimir
        String idPer = request.getParameter("id");
        if (idPer.isEmpty()) {
            mapMensajes.put("ID", "ID  no valido");
        }

        //Luego de verificar la inexistencia de problemas se realiza la consulta para obtener el permiso y redirigirlo para su impresion
        if (mapMensajes.isEmpty()) {
            try {
                //se rescata el permiso especifico
                List<PermisosDetalles> permiso = detalleDAO.find(idPer);
               //se setea coom atributo para luego rescatarlo desde jsp
                request.setAttribute("permisoActivo", permiso);                
                request.getRequestDispatcher("/ImpresionPermiso.jsp").forward(request, response);
            } catch (Exception e) {
                request.getRequestDispatcher("/ControllerMisPermisos").forward(request, response);
            }
        }

    }

}
