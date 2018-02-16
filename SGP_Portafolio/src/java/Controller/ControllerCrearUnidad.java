package Controller;

import DAO.UnidadesDAO;
import Model.Unidades;
import Model.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
 * @author Jordan Silva
 */
@WebServlet(name = "ControllerCrearUnidad", urlPatterns = {"/ControllerCrearUnidad"})
public class ControllerCrearUnidad extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Logger logger = Logger.getAnonymousLogger();
        HttpSession session = request.getSession();
        Map<String, String> mapMensajes = new HashMap<>();
        UnidadesDAO uniDAO = new UnidadesDAO();

        Unidades uni = new Unidades();
        String nombre = request.getParameter("codigo");
        if (nombre.isEmpty()) {
            mapMensajes.put("Usuario", "Debe Ingresar Nombre para la Unidad!!");

        } else {

            uni.setNombreunidad(nombre);
        }

        if (mapMensajes.size() == 0) {

            try {

                uniDAO.ingresarSP(uni);

                session.setAttribute("estado", "Funciona");

            } catch (Exception e) {
                session.setAttribute("estado", "Problemas");
                logger.log(Level.SEVERE, "Problemas al ingresar Unidad", e);
            } finally {

                response.sendRedirect("/SGP_Portafolio/NuevaUnidad.jsp");
            }

        } else {
            session.setAttribute("estado", "Problemas");
            response.sendRedirect("/SGP_Portafolio/VerificarDocumento.jsp");
        }

    }

}
