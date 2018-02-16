package Controller;


import DAO.PermisosDetalleDAO;

import Model.PermisosDetalles;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControllerMisPermisos", urlPatterns = {"/ControllerMisPermisos"})
public class ControllerMisPermisos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        PermisosDAO permisosDAO = new PermisosDAO();
        List<Permisos> permisos = permisosDAO.findAll();
        System.out.println(permisos);
        
         */

        DAO.PermisosDetalleDAO detalleDAO = new DAO.PermisosDetalleDAO();
        List<PermisosDetalles> permisos = detalleDAO.findAll();
        request.setAttribute("permisos", permisos);
        request.getRequestDispatcher("/MisPermisos.jsp").forward(request, response);
        
        
        
    }
}
