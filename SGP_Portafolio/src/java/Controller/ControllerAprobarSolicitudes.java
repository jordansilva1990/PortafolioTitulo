package Controller;

import DAO.PermisosDetalleDAO;
import Model.PermisosDetalles;
import Model.Usuarios;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.sun.mail.smtp.SMTPMessage;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Jordan Silva
 */
@WebServlet(name = "ControllerAprobarSolicitudes", urlPatterns = {"/ControllerAprobarSolicitudes"})
public class ControllerAprobarSolicitudes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Se inicializan variables necesarias para trabajar
        HttpSession session = request.getSession();
        Logger logger = Logger.getAnonymousLogger();

        //Se recupera la variable de sesion del usuario para obtener su ID mas adelante
        Usuarios user = (Usuarios) session.getAttribute("usuarioActivo");
        String idUsuario = javax.xml.bind.DatatypeConverter.printHexBinary(user.getIdUsuario());

        //Se crean variables para recuperar los permisos de la BD
        DAO.PermisosDetalleDAO detalleDAO = new DAO.PermisosDetalleDAO();

        //Se recuperan permisos en BD
        List<PermisosDetalles> permisos = detalleDAO.findAllByUserDepto(user);

        //Se setea la lista y redirecciona a Apobar solicitudes
        request.setAttribute("permisos", permisos);
        request.getRequestDispatcher("/AprobarSolicitudes.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Se inicializan variables necesarias para trabajar
        HttpSession session = request.getSession();
        Logger logger = Logger.getAnonymousLogger();
        Map<String, String> mapMensajes = new HashMap<>();
        PermisosDetalles perDet = new PermisosDetalles();
        PermisosDetalleDAO perDetDAO = new PermisosDetalleDAO();
        List<PermisosDetalles> lst = new ArrayList<>();
        String action = "";
        String idPerDet = "";

        //Se recupera la accion y el id a actualizar su estado
        String accion = request.getParameter("accion");
        if (accion.isEmpty()) {
            mapMensajes.put("Accion", "Es imposible realizar la operacion solicitada");
        } else {
            String[] parts = accion.split("-");
            action = parts[0];
            idPerDet = parts[1];

        }

        //Se revisa que no existan errores anteriores para proceder con las acciones de actualizacion
        if (mapMensajes.isEmpty()) {

            try {

                //Se recupera el permiso detalle con su id
                lst = perDetDAO.find(idPerDet);
                for (PermisosDetalles p : lst) {

                    //Se asigna el nuevo valor al estado dependiendo de la seleccion
                    if (action.equalsIgnoreCase("aprobar")) {

                        p.setEstado(new BigDecimal(2));

                    }
                    if (action.equalsIgnoreCase("rechazar")) {

                        p.setEstado(new BigDecimal(3));

                    }

                    perDetDAO.actualizarPermiso(p);
                }

                session.setAttribute("EstadoActualizacion", "Funciona");
            } catch (Exception e) {
                session.setAttribute("EstadoActualizacion", "Problemas");
                logger.log(Level.SEVERE, "Problemas al Actualizar el  Permiso", e);
            } finally {
                doGet(request, response);
            }
            String estado = "";
            PermisosDetalleDAO perdetal = new PermisosDetalleDAO();
            List<PermisosDetalles> prdt = new ArrayList<>();
            prdt = perdetal.find(idPerDet);

            if (prdt.get(0).getEstado().compareTo(new BigDecimal(1)) == 0) {
                estado = "Pendiente";
            } else if (prdt.get(0).getEstado().compareTo(new BigDecimal(2)) == 0) {
                estado = "Aprobado";
            } else if (prdt.get(0).getEstado().compareTo(new BigDecimal(3)) == 0) {
                estado = "Rechazado";
            }
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.socketFactory.port", "587");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "805");

            Session s = Session.getInstance(props, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("gonzalezpacheco.jonathan@gmail.com", "jgpxanfles291758");
                }
            });

            try {

                SMTPMessage message = new SMTPMessage(s);
                message.setFrom(new InternetAddress("gonzalezpacheco.jonathan@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(prdt.get(0).getUsuarios().getEmail()));

                message.setSubject("Cambio de Estado de Permiso");
                message.setText("Su permiso ha cambiado de estado a " + estado + " para más información visite el sitio web");
                message.setNotifyOptions(SMTPMessage.NOTIFY_SUCCESS);
                int returnOption = message.getReturnOption();
                System.out.println(returnOption);
                Transport.send(message);
                System.out.println("sent");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }

        }

    }

}
