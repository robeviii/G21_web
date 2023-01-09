/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AlumnoDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Alumno;

/**
 *
 * @author victor
 */
@WebServlet(name = "ControladorAlumno", urlPatterns = {"/ControladorAlumno"})

public class ControladorAlumno extends HttpServlet {


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
        response.setHeader("Cache-Control", "no-cache, no-store");
        HttpSession session  = request.getSession();
        if(session.getAttribute("email") == null){
            response.sendRedirect("/login");
            return;
        }
        
        AlumnoDao alumnoDao = new AlumnoDao();
        String accion = request.getParameter("action");
        RequestDispatcher dispatcher=null;

        if("ver_informe".equals(accion)){
            dispatcher = request.getRequestDispatcher("Alumno/ver_informe.jsp");
            Alumno alumno = alumnoDao.obtenerPorEmail(session.getAttribute("email").toString());
            String informe = alumno.getInforme();
            request.setAttribute("informe", informe);
            
        } else if("descargar_informe".equals(accion)){
            
        }
        
        dispatcher.forward(request, response);

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
        doGet(request, response);
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
