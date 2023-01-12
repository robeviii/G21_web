/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

import dao.AlumnoDao;
import dao.TutorDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.OutputStream;

import model.Alumno;
import model.Tutor;



/**
 * Servlet que descarga el informe de un alumno en PDF
 * @author 34646
 */
public class Pdf extends HttpServlet {
    
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
        
        HttpSession session  = request.getSession();
        if(session.getAttribute("email") == null){
            response.sendRedirect("login");
            return;
        }

        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        AlumnoDao alumnoDao = new AlumnoDao();
        TutorDao tutorDao = new TutorDao();
        Long id_alumno = Long.parseLong(request.getSession().getAttribute("id_alumno").toString());
        Alumno a = alumnoDao.obtener(id_alumno);
        Tutor t = tutorDao.obtener(a.getId_tutor());
        try{
            
            
            try{
            Document documento = new Document();
            PdfWriter.getInstance(documento, out);
            
            documento.open();
            
            //titulo
            Paragraph par1 = new Paragraph();
            Font fonttitulo = new Font(Font.FontFamily.HELVETICA,30, Font.BOLD,BaseColor.BLACK);
            par1.add(new Phrase("Reporte alumno", fonttitulo));
            par1.setAlignment(Element.ALIGN_CENTER);
            par1.add(new Phrase(Chunk.NEWLINE));
            par1.add(new Phrase(Chunk.NEWLINE));
            documento.add(par1);
            
            //descripcion
            Paragraph par2 = new Paragraph();
            Font fontdescrip = new Font(Font.FontFamily.TIMES_ROMAN,15, Font.NORMAL,BaseColor.BLACK);
            par2.add(new Phrase("Esto es un reporte del alumno " + a.getNombre(), fontdescrip));
            par2.setAlignment(Element.ALIGN_JUSTIFIED);
            par2.add(new Phrase(Chunk.NEWLINE));
            par2.add(new Phrase(Chunk.NEWLINE));
            documento.add(par2);
            
            
            //Datos del alumno 
            Paragraph par3 = new Paragraph();
            Font fontdatos = new Font(Font.FontFamily.TIMES_ROMAN,10, Font.NORMAL,BaseColor.BLACK);
            par3.add(new Phrase("Datos personales del alumno: ", fontdatos));
            par3.setAlignment(Element.ALIGN_JUSTIFIED);
            par3.add(new Phrase(Chunk.NEWLINE));
            par3.add(new Phrase(Chunk.NEWLINE));
            documento.add(par3);
            
            //Nombre
            Paragraph par4 = new Paragraph();
            par4.add(new Phrase("   -Nombre: " + a.getNombre(), fontdatos));
            par4.setAlignment(Element.ALIGN_JUSTIFIED);
            par4.add(new Phrase(Chunk.NEWLINE));
            par4.add(new Phrase(Chunk.NEWLINE));
            documento.add(par4);
            
            //DNI
            Paragraph par5 = new Paragraph();
            par5.add(new Phrase("   -DNI: " + a.getDni(), fontdatos));
            par5.setAlignment(Element.ALIGN_JUSTIFIED);
            par5.add(new Phrase(Chunk.NEWLINE));
            par5.add(new Phrase(Chunk.NEWLINE));
            documento.add(par5);
            
            //Email
            Paragraph par6 = new Paragraph();
            par6.add(new Phrase("   -Email: " + a.getEmail(), fontdatos));
            par6.setAlignment(Element.ALIGN_JUSTIFIED);
            par6.add(new Phrase(Chunk.NEWLINE));
            par6.add(new Phrase(Chunk.NEWLINE));
            documento.add(par6);
            
            //Datos de las practicas
            Paragraph par7 = new Paragraph();
            par7.add(new Phrase("Los datos de las practicas son los siguientes: ", fontdatos));
            par7.setAlignment(Element.ALIGN_JUSTIFIED);
            par7.add(new Phrase(Chunk.NEWLINE));
            par7.add(new Phrase(Chunk.NEWLINE));
            documento.add(par7);
            
            
            //Empresa
            Paragraph par11 = new Paragraph();
            //añadir aqui la funcion de mostrar empresa alumno
            par11.add(new Phrase("   -Empresa: " + a.getNombre_empresa_practicas(), fontdatos));
            par11.setAlignment(Element.ALIGN_JUSTIFIED);
            par11.add(new Phrase(Chunk.NEWLINE));
            par11.add(new Phrase(Chunk.NEWLINE));
            documento.add(par11);

            //Nota practicas
            Paragraph par8 = new Paragraph();
            par8.add(new Phrase("   -Nota en las practicas: " + a.getNota_practica(), fontdatos));
            par8.setAlignment(Element.ALIGN_JUSTIFIED);
            par8.add(new Phrase(Chunk.NEWLINE));
            par8.add(new Phrase(Chunk.NEWLINE));
            documento.add(par8);
            
            //Tutor Practicas
            Paragraph par9 = new Paragraph();
            par9.add(new Phrase("   -Tutor de las practicas " + t.getNombre() + " " + t.getApellido() , fontdatos));
            par9.setAlignment(Element.ALIGN_JUSTIFIED);
            par9.add(new Phrase(Chunk.NEWLINE));
            par9.add(new Phrase(Chunk.NEWLINE));
            documento.add(par9);
            
            //Informe practicas
            Paragraph par10 = new Paragraph();
            par10.add(new Phrase("Informe del tutor: " + a.getInforme(), fontdatos));
            par10.setAlignment(Element.ALIGN_JUSTIFIED);
            par10.add(new Phrase(Chunk.NEWLINE));
            par10.add(new Phrase(Chunk.NEWLINE));
            documento.add(par10);
    
            documento.close();
            
        }catch(Exception e){            System.out.println(e.getMessage());
}
        
        
        }finally {
            out.close();
        }
                
        
        
    }

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
