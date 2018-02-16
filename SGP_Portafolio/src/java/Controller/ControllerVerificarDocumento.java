package Controller;

import DAO.ResolucionDAO;
import Model.Resoluciones;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "ControllerVerificarDocumento", urlPatterns = {"/ControllerVerificarDocumento"})
public class ControllerVerificarDocumento extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Variables Necesarias
        Logger logger = Logger.getAnonymousLogger();
        HttpSession session = request.getSession();
        Map<String, String> mapMensajes = new HashMap<>();
        Resoluciones resoluc = new Resoluciones();
        ResolucionDAO resolucDAO = new ResolucionDAO();

        //Recuperacion de Variables de JSP
        String codigo = request.getParameter("codigo");
        if (codigo.isEmpty()) {
            mapMensajes.put("Codigo", "Debe Ingresar un Codigo!");
        }

        //Se realiza consulta  BD para verificar la existencia del Codigo del documento
        if (mapMensajes.isEmpty()) {
            List<Resoluciones> lst = resolucDAO.find(codigo);

            if (lst.size() > 0) {
                session.setAttribute("respuesta", "Documento Valido!");
            } else {
                session.setAttribute("respuesta", "Documento Invalido!");
            }

        } else {
            session.setAttribute("respuesta", "Debe ingresar un codigo a verificar!");
        }
        response.sendRedirect("/SGP_Portafolio/VerificarDocumento.jsp");

    }

}
