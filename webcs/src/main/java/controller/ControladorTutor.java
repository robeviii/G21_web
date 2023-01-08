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
import model.Alumno;
import model.Empresa;


/**
 *
 * @author 34646
 */
@WebServlet(name = "ControladorTutor", urlPatterns = {"/ControladorTutor"})
public class ControladorTutor extends HttpServlet {

    
    
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
        AlumnoDao alumnoDao = new AlumnoDao();
        String accion;
        RequestDispatcher dispatcher=null;
        
        accion = request.getParameter("accion");
        
        if("alta_empresa".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("Tutor/altaempresa.jsp");
            
        } else if("finalizar_practicas".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("Tutor/finalizar_practicas.jsp");
            List<Alumno> listaalumnos = alumnoDao.listaAlumnos(Long.parseLong(request.getSession().getAttribute("id_tutor").toString()));
            request.setAttribute("lista", listaalumnos);
            
        } else if("nuevaempresa".equals(accion)){
            
            Empresa empresa = new Empresa();

            empresa.setNombre(request.getParameter("nombre"));
            empresa.setDireccion(request.getParameter("direccion"));
            empresa.setAmbito(request.getParameter("ambito"));
            empresa.setWeb(request.getParameter("web"));
            empresa.setTelefono(request.getParameter("telefono"));
            empresa.setNalumnos(request.getParameter("n_alumnos"));
            empresa.setHorario(request.getParameter("horario"));
            empresa.setDuracion(request.getParameter("duracion"));
            empresa.setId_tutor(Integer.parseInt(request.getSession().getAttribute("id_tutor").toString()));

            empresaDAO.insertar(empresa);
            
            dispatcher = request.getRequestDispatcher("Tutor/alta_exito.jsp");  
            
        } else if("exitoalta".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("PanelControlView/PanelControlTutorView.jsp");
            
        } else if("darnota".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("Tutor/nota.jsp");
            int idalumno = Integer.parseInt(request.getParameter("idalumno"));
            Alumno alumno = alumnoDao.obtener(idalumno);
            request.setAttribute("alumno", alumno);
            
            
        } else if("actualizarnota".equals(accion)){
            Alumno alumno = new Alumno ();
            
            alumno.setId_tutor(Long.parseLong(request.getParameter("id_tutor_al")));
            alumno.setId(Integer.parseInt(request.getParameter("idalumno")));
            alumno.setDni(request.getParameter("dni"));
            alumno.setNota_media(Double.parseDouble(request.getParameter("notamedia")));
            alumno.setEmail(request.getParameter("email"));
            alumno.setNombre(request.getParameter("nombre_a"));
            alumno.setNota_practica(Double.parseDouble(request.getParameter("notaprac")));
            alumno.setInforme(request.getParameter("informe"));
            
            alumnoDao.actualizarNota(alumno);
            dispatcher = request.getRequestDispatcher("Tutor/finalizar_practicas.jsp");
            List<Alumno> listaalumnos = alumnoDao.listaAlumnos(Long.parseLong(request.getSession().getAttribute("id_tutor").toString()));
            request.setAttribute("lista", listaalumnos);
            
        } else if("escribirinforme".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("Tutor/escribir_informe.jsp");
            int idalumno = Integer.parseInt(request.getParameter("idalumno"));
            Alumno alumno = alumnoDao.obtener(idalumno);
            request.setAttribute("alumno", alumno);
            
        } else if("actualizarinforme".equals(accion)){
            
            Alumno alumno = new Alumno ();
            
            alumno.setId_tutor(Integer.parseInt(request.getParameter("id_tutor_al")));
            alumno.setId(Integer.parseInt(request.getParameter("idalumno")));
            alumno.setDni(request.getParameter("dni"));
            alumno.setNota_media(Double.parseDouble(request.getParameter("notamedia")));
            alumno.setEmail(request.getParameter("email"));
            alumno.setNombre(request.getParameter("nombre_a"));
            alumno.setNota_practica(Double.parseDouble(request.getParameter("notaprac")));
            alumno.setInforme(request.getParameter("informe"));
            
            alumnoDao.actualizarInforme(alumno);
            dispatcher = request.getRequestDispatcher("Tutor/finalizar_practicas.jsp");
            List<Alumno> listaalumnos = alumnoDao.listaAlumnos(Long.parseLong(request.getSession().getAttribute("id_tutor").toString()));
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
