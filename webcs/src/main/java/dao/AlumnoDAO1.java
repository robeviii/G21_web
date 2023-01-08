/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 34646
 */
public class AlumnoDAO1 {
    
    Connection conexion;
    
    public AlumnoDAO1(){
        
        Conexion con = new Conexion();
        conexion = con.getConexion();
        
    }
    
    
    public List<Alumno> listaAlumno(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        List<Alumno> lista = new ArrayList<>();
        
        try{
            ps = conexion.prepareStatement("SELECT * from alumno a INNER JOIN tutor t on a.id_tutor_al = t.idtutor");
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                Alumno a = new Alumno();
                a.setIdalumno(rs.getInt("idalumno")); 
                a.setDni(rs.getString("dni"));
                a.setNotamedia(rs.getInt("notamedia"));
                a.setEmail(rs.getString("email"));
                a.setNombre(rs.getString("nombre_a"));
                a.setNotaprac(rs.getInt("notaprac"));
                a.setInforme(rs.getString("informe"));
                a.setId_tutor_al(rs.getInt("id_tutor_al"));
                
                lista.add(a);
            }
            
            return lista;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return null;
            
        }
        
    }
    
    public boolean actualizarnota(Alumno alumno){
        
        PreparedStatement ps;        
        
        try{
            ps = conexion.prepareStatement("UPDATE alumno SET notaprac=? WHERE idalumno=?");
            ps.setInt(1, alumno.getNotaprac());
            ps.setInt(2, alumno.getIdalumno());
            ps.execute();
            
            return true;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return false;
            
        }
        
    }
    
    public boolean actualizarinforme(Alumno alumno){
        
        PreparedStatement ps;        
        
        try{
            ps = conexion.prepareStatement("UPDATE alumno SET informe=? WHERE idalumno=?");
            ps.setString(1, alumno.getInforme());
            ps.setInt(2, alumno.getIdalumno());
            ps.execute();
            
            return true;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return false;
            
        }
        
    }
    
    public Alumno mostrarAlumno(int _idalumno){
        
        PreparedStatement ps;
        ResultSet rs;
        Alumno alumno = null;
        
        try{
            ps = conexion.prepareStatement("SELECT * FROM alumno WHERE idalumno=?");
            ps.setInt(1, _idalumno);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                alumno = new Alumno();
                alumno.setIdalumno(rs.getInt("idalumno")); 
                alumno.setDni(rs.getString("dni"));
                alumno.setNotamedia(rs.getInt("notamedia"));
                alumno.setEmail(rs.getString("email"));
                alumno.setNombre(rs.getString("nombre_a"));
                alumno.setNotaprac(rs.getInt("notaprac"));
                alumno.setInforme(rs.getString("informe"));
                alumno.setId_tutor_al(rs.getInt("id_tutor_al"));
                
            }
            
            return alumno;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return null;
            
        }
        
    }
    
}
