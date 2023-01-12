/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import dao.AlumnoDao;
import dao.TutorDao;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import model.Alumno;
import model.Tutor;

/**
 * Clase responsable de mandar emails a los alumnos
 * @author victor
 */
public class EmailSender {

    private Properties props = new Properties();
    private Session session = null;
    private String correoRemitente = "pruebaresponsableg21@hotmail.com";
    private String passremitente = "selena14";

    private AlumnoDao alumnoDao = new AlumnoDao();
    private TutorDao tutorDao = new TutorDao();
    /**
     * Crea un servicio de envio de emails y establece sus propiedades
     */
    public EmailSender() {
        alumnoDao = new AlumnoDao();
        tutorDao = new TutorDao();
        
        props.setProperty("mail.smtp.ssl.trust", "*");
        props.setProperty("mail.smtp.host", "smtp-mail.outlook.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(props);
    }
    /**
     * Envia un email de bienvenida a las practicas al email del alumno
     * @param id_alumno 
     */
    public void enviarEmail(Long id_alumno) {
        
        try {
            Alumno a = alumnoDao.obtener(id_alumno);
            Tutor tutor = tutorDao.obtener(a.getId_tutor());
            String correoReceptor = a.getEmail();
            String asunto = "Admision Practicas";
            String mensaje = "Buenos días " + a.getNombre() + "\n\nNos complace comunicarle que ha sido admitido en las prácticas de la empresa " + a.getNombre_empresa_practicas() + ".\nSu tutor " + tutor.getNombre() + " se comunicará con usted en los siguientes días laborables" + "\n\n\nUniversidad de Alcalá de Henares";

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
            Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

}
