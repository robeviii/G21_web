/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AlumnoDao;
import dao.EmpresaDAO;
import dao.TutorDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.Alumno;
import model.Empresa;
import model.Tutor;
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
@WebServlet(name = "tutorcontroller", urlPatterns = {"/tutorcontroller"})
public class tutorcontroller extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        TutorDao tutorDAO = new TutorDao();
        EmpresaDAO empresaDAO = new EmpresaDAO();
        AlumnoDao alumnoDao = new AlumnoDao();
        String accion;
        RequestDispatcher dispatcher=null;
        
        accion = request.getParameter("accion");
        
        if(accion == null || accion.isEmpty()){
            
            dispatcher = request.getRequestDispatcher("/index.jsp");
          
        } else if("alta_empresa".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("/altaempresa.jsp");
            System.out.println(request.getParameter("idtutor"));
            
        } else if("finalizar_practicas".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("/finalizar_practicas.jsp");
            List<Alumno> listaalumnos = alumnoDAO.listaAlumno();
            request.setAttribute("lista", listaalumnos);
            
        } else if("nuevaempresa".equals(accion)){
                        
            String nombre = request.getParameter("nombre");
            String direccion = request.getParameter("direccion");
            String ambito = request.getParameter("ambito");
            String web = request.getParameter("web");
            String telefono = request.getParameter("telefono");
            String n_alumnos = request.getParameter("n_alumnos");
            String horario = request.getParameter("horario");
            String duracion = request.getParameter("duracion");
            int id_tutor = Integer.parseInt(request.getParameter("id_tutor"));

            Empresa empresa = new Empresa (1, nombre, direccion, ambito, web, telefono, n_alumnos, horario, duracion, id_tutor);
            empresaDAO.insertar(empresa);
            
            dispatcher = request.getRequestDispatcher("/alta_exito.jsp");  
            
        } else if("exitoalta".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("/index.jsp");
            
        } else if("darnota".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("/nota.jsp");
            int idalumno = Integer.parseInt(request.getParameter("idalumno"));
            Alumno alumno = alumnoDAO.mostrarAlumno(idalumno);
            request.setAttribute("alumno", alumno);
            
            
        } else if("actualizarnota".equals(accion)){
            
            int id_tutor_al = Integer.parseInt(request.getParameter("id_tutor_al"));
            int idalumno = Integer.parseInt(request.getParameter("idalumno"));
            String dni = request.getParameter("dni");
            int notamedia = Integer.parseInt(request.getParameter("notamedia"));
            String email = request.getParameter("email");
            String nombre = request.getParameter("nombre_a");
            int notaprac = Integer.parseInt(request.getParameter("notaprac"));
            String informe = request.getParameter("informe");
            Alumno alumno = new Alumno (dni, email, nombre, informe, idalumno, notamedia, notaprac, id_tutor_al);            
            alumnoDAO.actualizarnota(alumno);
            dispatcher = request.getRequestDispatcher("/finalizar_practicas.jsp");
            List<Alumno> listaalumnos = alumnoDAO.listaAlumno();
            request.setAttribute("lista", listaalumnos);
            
        } else if("escribirinforme".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("/escribir_informe.jsp");
            int idalumno = Integer.parseInt(request.getParameter("idalumno"));
            Alumno alumno = alumnoDAO.mostrarAlumno(idalumno);
            request.setAttribute("alumno", alumno);
            
        } else if("actualizarinforme".equals(accion)){
            
            int id_tutor_al = Integer.parseInt(request.getParameter("id_tutor_al"));
            int idalumno = Integer.parseInt(request.getParameter("idalumno"));
            String dni = request.getParameter("dni");
            int notamedia = Integer.parseInt(request.getParameter("notamedia"));
            String email = request.getParameter("email");
            String nombre = request.getParameter("nombre_a");
            int notaprac = Integer.parseInt(request.getParameter("notaprac"));
            String informe = request.getParameter("informe");
            Alumno alumno = new Alumno (dni, email, nombre, informe, idalumno, notamedia, notaprac, id_tutor_al);
            alumnoDAO.actualizarinforme(alumno);
            dispatcher = request.getRequestDispatcher("/finalizar_practicas.jsp");
            List<Alumno> listaalumnos = alumnoDAO.listaAlumno();
            request.setAttribute("lista", listaalumnos);
            
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
