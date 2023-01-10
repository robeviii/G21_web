/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AlumnoDao;
import dao.EmpresaDao;
import dao.PracticasDao;
import dao.TutorDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import model.Empresa;
import model.Alumno;
import model.Practica;

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
        
        PracticasDao practicasDao = new PracticasDao();
        EmpresaDao empresaDAO = new EmpresaDao();
        AlumnoDao alumnoDAO = new AlumnoDao();
        String accion;
        RequestDispatcher dispatcher=null;
        
        accion = request.getParameter("accion");
        
       if("mostrarempresas".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("/responsable/listaempresas.jsp");
            List<Empresa> listaempresas = empresaDAO.listaEmpresa();
            request.setAttribute("lista", listaempresas);        
            dispatcher.forward(request, response);
        }
        else if("mostraralumnos".equals(accion)){
            
            dispatcher = request.getRequestDispatcher("/responsable/listaalumnos.jsp");
            int id_tutor = Integer.parseInt(request.getParameter("id_tutor"));
            List<Alumno> listaalumnos = alumnoDAO.listaAlumnos(id_tutor);
            request.setAttribute("lista", listaalumnos);
            dispatcher.forward(request, response);
        }else if ("asignarpracticas".equals(accion)) {
            
            //Obtiene todas las empresas que ofertan practicas
            List<String> empresas = practicasDao.obtenerEmpresasConPracticas();           
            
            //Rellena un mapa con las empresas y sus plazas libres (0 al principio)
            Map<String, Integer> plazasEmpresa = new HashMap<>();
            plazasEmpresa = inicializarPlazas(empresas);
            
            //Recorre todas las preferencias para ir asignando de mayor a menor prioridad
            for (int i = 1; i<=10; i++){
            
                // Recorre todas las empresas que ofertan practicas y las actualiza en cada preferencia
                // Por si ya se han asignado las plazas
                
                empresas = practicasDao.obtenerEmpresasConPracticas();          

                for (String empresa: empresas){
                    // Obtiene las practicas de los alumnos que han solicitado una empresa en una preferencia especifica
                    // ordenadas por nota media de estos alumnos
                    List<Practica> practicas = practicasDao.obtenerPracticasPorEmpresaPreferenciaOrdenadas(empresa,i);
                    
                    // Obtiene las plazas maximas de la empresa
                    int maxPlazas = empresaDAO.obtenerMaxAlumnos(empresa);
                    // Recorre las practicas y va asignandolas en de mayor nota en menor nota.
                    
                    for (Practica practica : practicas){
                        
                        // Si hay hueco se asigna al alumno y se borran el resto de sus solicitudes
                        // ademas se resta una plaza de las disponibles en la empresa
                        if (plazasEmpresa.get(empresa) < maxPlazas){
                            
                            alumnoDAO.asignarEmpresa(practica.getId_alumno(), practica.getNombre_empresa());
                            practicasDao.eliminarPracticasAlumno(practica.getId_alumno());
                            plazasEmpresa.merge(empresa, 1, Integer::sum);
                        // Si no hay hueco se borra esa empresa de las practicas
                        // Y se pasa a la siguiente empresa
                        }else{
                            practicasDao.eliminarPracticasEmpresa(empresa);
                            break;
                        }
                       
                    }
                }
            }
            
            
            
            response.sendRedirect("/ControladorResponsable?accion=practicas");
            
        }else if("practicas".equals(accion)){
            List<Practica> practicas = practicasDao.listaPracticas();
            System.out.println(practicas);
            if (practicas.isEmpty()){
                request.setAttribute("hay_practicas", false);
                
            }else{
                request.setAttribute("hay_practicas", true);

            }
            
            dispatcher = request.getRequestDispatcher("/responsable/asignacionpracticas.jsp");
            dispatcher.forward(request, response);
        }
        
        
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

    public void asignarPracticas(){
        
    }
    public Map<String,Integer> inicializarPlazas(List<String> empresas){
        
        Map<String, Integer> plazasEmpresa = new HashMap<>();

        for(String empresa: empresas){
            plazasEmpresa.put(empresa,0);
        }
        return plazasEmpresa;
    }
   
}
