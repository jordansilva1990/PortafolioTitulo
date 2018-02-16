package Controller;

import DAO.PermisosDAO;
import DAO.TiposPermisosDAO;
import Model.Permisos;
import Model.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

        HttpSession session = request.getSession();
        Logger logger = Logger.getAnonymousLogger();
        Map<String, String> mapMensajes = new HashMap<>();
        byte[] idTipo = "error".getBytes();

        Permisos per = new Permisos();        
        PermisosDAO perDAO = new PermisosDAO();
        

        //Se obtiene variable desde input para setear al objeto
        String motivo = request.getParameter("motivo");
        if (motivo.isEmpty()) {
            mapMensajes.put("Tipo", "Debe Ingresar Tipo de permiso");
        } else {
            per.setTipopermiso(motivo);
        }

        String tipoStr = request.getParameter("tipo");
        if (tipoStr.isEmpty()) {
            mapMensajes.put("Seleccione Tipo", "Debe Selecciona un tipo de permiso");
        } else {
            idTipo = tipoStr.getBytes();
        }

        

        Usuarios user = (Usuarios) session.getAttribute("usuarioActivo");
        

        
        
        //Luego de recuperar  y validar los datos necesarios se procede a intentar el ingreso del objeto a BD
        try {
            if (mapMensajes.size() == 0) {

               perDAO.ingresarSP(per, user.getIdUsuario(), idTipo);
                
            }
            session.setAttribute("EstadoSolicitud", "Funciona");
        } catch (Exception e) {
            session.setAttribute("EstadoSolicitud", "Problemas");
            logger.log(Level.SEVERE, "Problemas al ingresar Permiso", e);
        } finally {
            doGet(request, response);
        }

    }

}
