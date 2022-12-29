package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dao.TutorDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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

    private TutorDao dao;
    
    public LoginServlet() {
        super();
        dao = new TutorDao();
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
        Tutor tutor = dao.get(email);
        if (tutor != null && tutor.getPassword().equals(pwd)){
            Log.log.info("tutor logueado con exito");
            HttpSession session = request.getSession();
            session.setAttribute("nombre", tutor.getNombre());
            session.setAttribute("apellido", tutor.getApellido());
            session.setAttribute("email", email);
            
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
            
            response.sendRedirect("test/testDashboard.jsp");            

        }
        else {
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

}
