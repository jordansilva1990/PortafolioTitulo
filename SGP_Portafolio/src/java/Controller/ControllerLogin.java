/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuariosDAO;
import Model.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
                BDuser.setNombre(user.getNombre());
                BDuser.setContrasena(user.getContrasena());
                BDuser.setPerfiles(user.getPerfiles());
                BDuser.setRut(user.getRut());
                BDuser.setUnidades(user.getUnidades());
                BDuser.setIdUsuario(user.getIdUsuario());

            }

                
               
               
               
               
            try {
                if (BDuser.getRut().equalsIgnoreCase(rut) && BDuser.getContrasena().equals(pass)) {
                    //Definir Perfil
               String perfilStr =  BDuser.getPerfiles().getNombreperfil();
               int perf=0;
               
              switch(perfilStr){
                  case "administrador":perf=1;
                      break;
                  case "alcalde":perf=2;
                      break;
                  case "sudo":perf=3;   
                      break;
                  case "funcionario":perf=4;
                      break;
                  case "jefe unidad interna":perf=5;
                      break;
                  case "jefe superior":perf=6;
                      break;
                      
                  default: perf=0;
                      break;
              }
                    
                    
                    session.setAttribute("usuarioActivo", BDuser);
                    session.setAttribute("perfil", perf);
                    response.sendRedirect("/SGP_Portafolio/Dashboard.jsp");
                } else {
                    session.setAttribute("estado", "Usuario y/o Contraseña Incorrectos");                   
                    response.sendRedirect("/SGP_Portafolio/Login.jsp");
                }
            } catch (Exception e) {
               session.setAttribute("estado", "Usuario y/o Contraseña no encontrados");               
                response.sendRedirect("/SGP_Portafolio/Login.jsp");
            }

       
        } else {
            session.setAttribute("estado", "Debe ingresar Contraseña y Correo para continuar");
            response.sendRedirect("/SGP_Portafolio/Login.jsp");
        }

        
        
    }

   

}
