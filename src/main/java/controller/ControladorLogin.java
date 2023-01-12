package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dao.AlumnoDao;
import dao.ResponsableDao;
import dao.TutorDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Alumno;
import model.Responsable;
import model.Tutor;
import util.Log;

/**
 * Controlador para el funcionamiento del login
 * @author victor
 */

public class ControladorLogin extends HttpServlet {

    private TutorDao daoTutor;
    private AlumnoDao daoAlumno;
    private ResponsableDao daoResponsable;
    
    public ControladorLogin() {
        super();
        daoTutor = new TutorDao();
        daoAlumno = new AlumnoDao();
        daoResponsable = new ResponsableDao();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean cerrarSesion = false;
        cerrarSesion = Boolean.valueOf(request.getParameter("cerrarSesion"));
        
        if (cerrarSesion){
            //Cierra la sesion en caso de que se requiera por el parametro de URL
            HttpSession sesion = request.getSession();
            sesion.invalidate();
        }
        
        
        String forward = "LoginView/LoginView.jsp";
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String pwd = request.getParameter("password");
        
        if (buscaAlumno(email, pwd, request)){
            response.sendRedirect("panelAlumno");            

            return;
        }
        
        else if (buscaTutor(email, pwd, request)){
            response.sendRedirect("panelTutor");            

            return;
        }else if (buscaResponsable(email, pwd, request)){
            response.sendRedirect("panelResponsable");            

            return;
        }else {
            Log.log.info("Error de login");
            HttpSession session = request.getSession();
            session.setAttribute("nologin", true);
            
            response.sendRedirect("login");      
                
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    /**
     * Comprueba si existe un alumno con esas credenciales
     * @param email email insertado en el login
     * @param pwd contraseña insertada en el login
     * @param request request del login para establecer los atributos del alumno
     * @return true o false dependiendo si existe o no
     */
    private boolean buscaAlumno(String email, String pwd, HttpServletRequest request){
        Alumno alumno = daoAlumno.obtenerPorEmail(email);
        
        if(alumno != null && alumno.getPassword().equals(pwd)){
            Log.log.info("alumno logueado con exito");
            HttpSession session = request.getSession();
            session.setAttribute("id_alumno",alumno.getId());
            session.setAttribute("nombre", alumno.getNombre());
            session.setAttribute("dni", alumno.getDni());
            session.setAttribute("email", email);
            session.setAttribute("nota_media", alumno.getNota_media());
            session.setAttribute("id_tutor", alumno.getId_tutor());
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60); 

            return true;
        }
        return false;
    }
    /**
     * Comprueba si existe un responsable con esas credenciales
     * @param email email insertado en el login
     * @param pwd contraseña insertada en el login
     * @param request request del login para establecer los atributos del responsable
     * @return true o false dependiendo si existe o no
     */
    private boolean buscaResponsable(String email, String pwd, HttpServletRequest request){
        Responsable responsable = daoResponsable.obtenerPorEmail(email);
        
        if(responsable != null && responsable.getPassword().equals(pwd)){
            Log.log.info("alumno logueado con exito");
            HttpSession session = request.getSession();
            session.setAttribute("id_responsable",responsable.getId());
            session.setAttribute("nombre", responsable.getNombre());
            session.setAttribute("email", email);
            session.setAttribute("apellido", responsable.getApellido());
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60); 

            return true;
        }
        return false;
    }
    /**
     * Comprueba si existe un tutor con esas credenciales
     * @param email email insertado en el login
     * @param pwd contraseña insertada en el login
     * @param request request del login para establecer los atributos del tutor
     * @return true o false dependiendo si existe o no
     */
    private boolean buscaTutor(String email, String pwd, HttpServletRequest request){
        Tutor tutor = daoTutor.obtenerPorEmail(email);
        
        if (tutor != null && tutor.getPassword().equals(pwd)){
            Log.log.info("tutor logueado con exito");
            HttpSession session = request.getSession();
            session.setAttribute("nombre", tutor.getNombre());
            session.setAttribute("apellido", tutor.getApellido());
            session.setAttribute("email", email);
            session.setAttribute("id_tutor", tutor.getId());

            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
          
            return true;
        }
        return false;
    }
    
}
