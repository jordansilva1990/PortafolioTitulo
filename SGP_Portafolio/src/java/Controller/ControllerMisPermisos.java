package Controller;


import DAO.PermisosDetalleDAO;

import Model.PermisosDetalles;
import Model.Usuarios;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControllerMisPermisos", urlPatterns = {"/ControllerMisPermisos"})
public class ControllerMisPermisos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Logger logger = Logger.getAnonymousLogger();
        
        //Se crean variables para recuperar los permisos de la BD
        DAO.PermisosDetalleDAO detalleDAO = new DAO.PermisosDetalleDAO();
        
        //Se recupera la variable de sesion del usuario para obtener su ID mas adelante
        Usuarios user = (Usuarios) session.getAttribute("usuarioActivo");
        String idUsuario= javax.xml.bind.DatatypeConverter.printHexBinary(user.getIdUsuario());
        
        //Se recuperan permisos en BD
        List<PermisosDetalles> permisos = detalleDAO.findAllByUser(user);
        
        //Se setea la lista y redirecciona Mis Permisos
        request.setAttribute("permisos", permisos);
        request.getRequestDispatcher("/MisPermisos.jsp").forward(request, response);
        
        
        
    }
}
