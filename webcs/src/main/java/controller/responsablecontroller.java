/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import modelo.Empresa;
import modelo.EmpresaDAO;
import modelo.Tutor;
import modelo.TutorDAO;
import modelo.Alumno;
import modelo.AlumnoDAO;

/**
 *
 * @author 34646
 */
@WebServlet(name = "responsablecontroller", urlPatterns = {"/responsablecontroller"})
public class responsablecontroller extends HttpServlet {
    


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        TutorDAO tutorDAO = new TutorDAO();
        EmpresaDAO empresaDAO = new EmpresaDAO();
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        String accion;
        RequestDispatcher dispatcher=null;
        
        accion = request.getParameter("accion");
        
        if(accion == null || accion.isEmpty()){
            
            dispatcher = request.getRequestDispatcher("/responsable/indexres.jsp");
          
        } else if("mostrarempresas".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("/responsable/listaempresas.jsp");
            List<Empresa> listaempresas = empresaDAO.listaempresa();
            request.setAttribute("lista", listaempresas);            
        }
        else if("mostraralumnos".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("/responsable/listaalumnos.jsp");
            int id_tutor = Integer.parseInt(request.getParameter("id_tutor"));
            List<Alumno> listaalumnos = alumnoDAO.listaAlumnoEmpresa(id_tutor);
            request.setAttribute("lista", listaalumnos);
            
            
        }else if("volverindex".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("/responsable/indexres.jsp");
            
        }else if("volverlistaempresa".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("/responsable/listaempresas.jsp");
            List<Empresa> listaempresas = empresaDAO.listaempresa();
            request.setAttribute("lista", listaempresas);
            
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
