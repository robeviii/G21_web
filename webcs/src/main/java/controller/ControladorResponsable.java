/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AlumnoDao;
import dao.EmpresaDao;
import dao.TutorDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Empresa;
import model.Alumno;

/**
 *
 * @author 34646
 */
@WebServlet(name = "ControladorResponsable", urlPatterns = {"/ControladorResponsable"})
public class ControladorResponsable extends HttpServlet {
    


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setHeader("Cache-Control", "no-cache, no-store");
        
        if(request.getSession().getAttribute("email") == null){
            response.sendRedirect("/login");
            return;
        }
        
        TutorDao tutorDAO = new TutorDao();
        EmpresaDao empresaDAO = new EmpresaDao();
        AlumnoDao alumnoDAO = new AlumnoDao();
        String accion;
        RequestDispatcher dispatcher=null;
        
        accion = request.getParameter("accion");
        
       if("mostrarempresas".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("/responsable/listaempresas.jsp");
            List<Empresa> listaempresas = empresaDAO.listaEmpresa();
            request.setAttribute("lista", listaempresas);            
        }
        else if("mostraralumnos".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("/responsable/listaalumnos.jsp");
            int id_tutor = Integer.parseInt(request.getParameter("id_tutor"));
            List<Alumno> listaalumnos = alumnoDAO.listaAlumnos(id_tutor);
            request.setAttribute("lista", listaalumnos);
            
          
        }else if("organizaralumnos".equals(accion)){
            
            System.out.println("no implementado todavia");
            
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
