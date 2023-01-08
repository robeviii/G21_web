package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dao.AlumnoDao;
import dao.TutorDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Alumno;
import model.Tutor;
import util.Log;

/**
 *
 * @author victor
 */
@WebServlet(
  name = "LoginServlet", 
  urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private TutorDao daoTutor;
    private AlumnoDao daoAlumno;
    
    public LoginServlet() {
        super();
        daoTutor = new TutorDao();
        daoAlumno = new AlumnoDao();

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
        
        //Cierra la sesion en caso de que hubiese alguna abierta
        HttpSession sesion = request.getSession();
        sesion.invalidate();
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
        boolean estaLogueado = false;
        
        if (buscaAlumno(email, pwd, request)){
            response.sendRedirect("/panelAlumno");            

            return;
        }
        
        if (buscaTutor(email, pwd, request)){
            //Panel de control test
            response.sendRedirect("/panelTutor");            

            return;
        }else {
            Log.log.info("Error de login");
            HttpSession session = request.getSession();
            session.setAttribute("email", "notexists");
            
            response.sendRedirect("/login");      
                
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
    
    private boolean buscaAlumno(String email, String pwd, HttpServletRequest request){
        Alumno alumno = daoAlumno.get(email);
        
        if(alumno != null && alumno.getPassword().equals(pwd)){
            Log.log.info("alumno logueado con exito");
            HttpSession session = request.getSession();
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
    private boolean buscaTutor(String email, String pwd, HttpServletRequest request){
        Tutor tutor = daoTutor.get(email);
        
        if (tutor != null && tutor.getPassword().equals(pwd)){
            Log.log.info("tutor logueado con exito");
            HttpSession session = request.getSession();
            session.setAttribute("nombre", tutor.getNombre());
            session.setAttribute("apellido", tutor.getApellido());
            session.setAttribute("email", email);
            
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
          
            return true;
        }
        return false;
    }
    
}
