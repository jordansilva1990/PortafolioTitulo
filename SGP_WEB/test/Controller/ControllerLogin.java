/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Usuarios;
import java.io.IOException;
import DAO.
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@WebServlet(name = "ControllerLogin", urlPatterns = {"/ControllerLogin"})
public class ControllerLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Map<String, String> mapMensajes = new HashMap<>();

        Usuarios usu = new Usuarios();
        String rut = request.getParameter("rut");
        if (rut.isEmpty()) {
            mapMensajes.put("Usuario", "Debe Ingresar RUT de Usuario!!");

        } else {

            usu.setEmail(rut);
        }

        String pass = request.getParameter("password");
        if (pass.isEmpty()) {
            mapMensajes.put("Password", "Debe Ingresar contraseña!!");
        } else {
            usu.setContrasena(pass);
        }

        if (mapMensajes.size() == 0) {
            UsuariosDAO usuDAO = new UsuariosDAO();
            List<Usuarios> usuario = usuDAO.find(rut);
            Usuarios BDuser = new Usuarios();

            for (Usuarios user : usuario) {

                BDuser.setEmail(user.getEmail());
                BDuser.setContrasena(user.getContrasena());
                BDuser.setPerfiles(user.getPerfiles());
                BDuser.setRut(user.getRut());
                BDuser.setUnidades(user.getUnidades());
                BDuser.setIdUsuario(user.getIdUsuario());

            }

            try {
                if (BDuser.getRut().equalsIgnoreCase(rut) && BDuser.getContrasena().equals(pass)) {
                    session.setAttribute("usuarioActivo", BDuser);
                    response.sendRedirect("/SGP_WEB/Dashboard.jsp");
                } else {
                    session.setAttribute("estado", "Usuario y/o Contraseña Incorrectos");
                    response.sendRedirect("/SGP_WEB/Login.jsp");
                }
            } catch (Exception e) {
            }

        //request.getRequestDispatcher("/crearCarrera.jsp").forward(request, response);  
        } else {
            session.setAttribute("estado", "Debe ingresar Contraseña y Correo para continuar");
            response.sendRedirect("/SGP_WEB/Login.jsp");
        }

    }

}
