package Controller;

import DAO.ResolucionDAO;
import DAO.ResolucionDetalleDAO;
import DAO.TiposPermisosDAO;
import DAO.UnidadesDAO;
import Model.ResolucionesDetalle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jordan Silva
 */
@WebServlet(name = "ControllerNuevaResolucion", urlPatterns = {"/ControllerNuevaResolucion"})
public class ControllerNuevaResolucion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ResolucionDetalleDAO resoluDetalleDAO = new ResolucionDetalleDAO();
            List<ResolucionesDetalle> resoluDeta = resoluDetalleDAO.findAll();
            ResolucionDAO resolucion = new ResolucionDAO();
            List<String> lista = new ArrayList<String>();
            request.setAttribute("resoluciones", resolucion.findAll());
            request.setAttribute("ResolucionesDetalle", resoluDeta);
        } catch (Exception e) {
        }
        request.getRequestDispatcher("/GenerarResoluciones.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
