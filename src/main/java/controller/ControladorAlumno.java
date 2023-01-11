/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AlumnoDao;
import dao.EmpresaDao;
import dao.PracticasDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Alumno;
import model.Empresa;
import model.Practica;
import util.Log;

/**
 *
 * @author victor
 */

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
            response.sendRedirect("login");
            return;
        }
        
        AlumnoDao alumnoDao = new AlumnoDao();
        EmpresaDao empresaDao = new EmpresaDao();
        PracticasDao practicaDao = new PracticasDao();
        String accion = request.getParameter("accion");
        RequestDispatcher dispatcher=null;

        if("ver_informe".equals(accion)){
            dispatcher = request.getRequestDispatcher("Alumno/ver_informe.jsp");
            Alumno alumno = alumnoDao.obtenerPorEmail(session.getAttribute("email").toString());
            String informe = alumno.getInforme();
            session.setAttribute("informe", informe);
            dispatcher.forward(request, response);
            
        } else if("descargar_informe".equals(accion)){
          //TODO opcion para generar el informe y descargarlo como pdf  
        } else if ("solicitud_practicas".equals(accion)){
            dispatcher = request.getRequestDispatcher("Alumno/solicitud_practicas.jsp");

            List<Empresa> empresasTotal = empresaDao.listaEmpresa();
            List<Integer> preferencias = new ArrayList<>();;
            preferencias.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

            List<Empresa> empresasSinSolicitar = null;
            Map<Integer,Empresa> empresasSolicitadas = new HashMap<>();
            
            Map<String,Integer> nombreEmpresasSolicitadas = practicaDao.obtenerNombreEmpresasSolicitadasPorPreferenciaAlumno(Long.parseLong(session.getAttribute("id_alumno").toString()));
            
            if (nombreEmpresasSolicitadas.isEmpty()){
                empresasSinSolicitar = empresasTotal;
            }
            else{
                empresasSinSolicitar = obtenerEmpresasSinSolicitar(empresasTotal,nombreEmpresasSolicitadas);
                empresasSolicitadas = obtenerEmpresasSolicitadas(empresasTotal, nombreEmpresasSolicitadas);
                preferencias.removeAll(empresasSolicitadas.keySet());
            }
            request.getSession().setAttribute("empresas_no_solicitadas", empresasSinSolicitar);
            request.getSession().setAttribute("empresas_solicitadas", empresasSolicitadas);
            request.getSession().setAttribute("preferencias", preferencias);
            
            dispatcher.forward(request, response);
        }else if("añadir_practicas".equals(accion)){
            
            List<String> nombres_empresa = new ArrayList<>(request.getParameterMap().keySet());
            List<Integer> preferenciasElegidas = new ArrayList<>();
            int preferencia;
            
            
            for (String nombre_empresa : nombres_empresa){
                
                try{
                    preferencia = Integer.parseInt(request.getParameter(nombre_empresa));
                }catch (NumberFormatException e){
                    Log.log.warn("El parametro no es una empresa, se comprobara el siguiente");
                    continue;
                
                }
                if (preferencia != 0 && !preferenciasElegidas.contains(preferencia)){
                    Practica practica = new Practica();

                    practica.setId_alumno(Long.parseLong(session.getAttribute("id_alumno").toString()));
                    practica.setNombre_empresa(nombre_empresa);
                    practica.setPreferencia(Integer.parseInt(request.getParameter(nombre_empresa)));

                    practicaDao.actualizarPractica(practica);
                    preferenciasElegidas.add(preferencia);
                }
                
            }
            
            response.sendRedirect("ControladorAlumno?accion=solicitud_practicas");
        }else if("eliminar_practicas".equals(accion)){
            
            List<String> parametros = new ArrayList<>(request.getParameterMap().keySet());
            System.out.println(parametros.get(1));
            Practica practica = new Practica();

            practica.setId_alumno(Long.parseLong(session.getAttribute("id_alumno").toString()));
            practica.setNombre_empresa(parametros.get(parametros.size()-1).toString());
            
            practicaDao.eliminarPractica(practica);
            
            response.sendRedirect("ControladorAlumno?accion=solicitud_practicas");
        }
        
        else {
            dispatcher = request.getRequestDispatcher("PanelControlView/PanelControlAlumnoView.jsp");
            dispatcher.forward(request, response);
        }
        
        

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
         
    
    private List<Empresa> obtenerEmpresasSinSolicitar(List<Empresa> empresas, Map<String,Integer> practicasSolicitadas){
                
        List<Empresa> empresasSinSolicitar = new ArrayList<>();
        
        for (Empresa empresa: empresas){
            if(!practicasSolicitadas.keySet().contains(empresa.getNombre())){
                empresasSinSolicitar.add(empresa);
            }
            
        }
        return empresasSinSolicitar;
    }
    private Map<Integer,Empresa> obtenerEmpresasSolicitadas(List<Empresa> empresas, Map<String,Integer> practicasSolicitadas){
                
        Map<Integer,Empresa> empresasSolicitadas = new HashMap<>();
        
        for (Empresa empresa : empresas ){
            if(practicasSolicitadas.keySet().contains(empresa.getNombre())){
                empresasSolicitadas.put(practicasSolicitadas.get(empresa.getNombre()), empresa);
            }
            
        }
        return empresasSolicitadas;
    }
}
