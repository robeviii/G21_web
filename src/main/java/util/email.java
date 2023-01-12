/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package util;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import modelo.Alumno;
import modelo.AlumnoDAO;
import modelo.Empresa;
import modelo.Tutor;
import modelo.TutorDAO;

/**
 *
 * @author 34646
 */
@WebServlet(name = "email", urlPatterns = {"/email"})
public class email extends HttpServlet {

   /* protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        try {
            response.setContentType("text/html;charset=UTF-8");

            RequestDispatcher dispatcher = null;
            AlumnoDAO alumnoDAO = new AlumnoDAO();
            TutorDAO tutorDAO = new TutorDAO();
            Alumno a = alumnoDAO.mostrarAlumno(1);
            Tutor tutor = tutorDAO.mostrartTutor(a.getId_tutor_al());

            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp-mail.outlook.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "pruebaresponsableg21@hotmail.com";
            String passremitente = "selena14";
            String correoReceptor = "pruebaalumnog21@hotmail.com";
            String asunto = "Admision Practicas";
            String mensaje = "Buenos días " + a.getNombre() + "\n\nNos complace comunicarle que ha sido admitido en las prácticas (añadir nombre de la empresa)" + "\nSu tutor " + tutor.getNombre() + " se comunicará con usted en los siguientes días laborables" + "\n\n\nUniversidad de Alcalá de Henares";

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje);

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passremitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));

            System.out.println("Se ha enviado el correo");
            
            dispatcher = request.getRequestDispatcher("/confirmacion_email.jsp");

        } catch (AddressException ex) {
            Logger.getLogger(email.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(email.class.getName()).log(Level.SEVERE, null, ex);
        }

        

    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        TutorDAO tutorDAO = new TutorDAO();
        Alumno a = alumnoDAO.mostrarAlumno(1);
        Tutor tutor = tutorDAO.mostrartTutor(a.getId_tutor_al());
        String accion;
        RequestDispatcher dispatcher=null;
        
        accion = request.getParameter("accion");
        
        if(accion == null || accion.isEmpty()){
            
            dispatcher = request.getRequestDispatcher("/envio_email/email.jsp");
            
        } else if("envio_email".equals(accion)){
            try{
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp-mail.outlook.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "pruebaresponsableg21@hotmail.com";
            String passremitente = "selena14";
            String correoReceptor = "pruebaalumnog21@hotmail.com";
            String asunto = "Admision Practicas";
            String mensaje = "Buenos días " + a.getNombre() + "\n\nNos complace comunicarle que ha sido admitido en las prácticas (añadir nombre de la empresa)" + "\nSu tutor " + tutor.getNombre() + " se comunicará con usted en los siguientes días laborables" + "\n\n\nUniversidad de Alcalá de Henares";

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje);

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passremitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));

            System.out.println("Se ha enviado el correo");
            
            } catch (AddressException ex) {
            Logger.getLogger(email.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException ex) {
            Logger.getLogger(email.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            dispatcher = request.getRequestDispatcher("/envio_email/confirmacion_email.jsp");
                       
        }else if("volverindex".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("/responsable/indexres.jsp");         
        }
        
        dispatcher.forward(request, response);
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
