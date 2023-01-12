/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Practica;
import util.DbUtil;
import util.Log;

/**
 *
 * @author victor
 */
public class PracticasDao {
    Connection connection;
    /**
     * Crea un Dao para practicas
     */
    public PracticasDao(){
        Log.logdb.info("Conectando para PracticasDao...\n");
        connection = DbUtil.getConnection();
        Log.logdb.info("Conectado!\n");
        
    }
    /**
     * Elimina todas las practicas solicitadas a una empresa especifica
     * @param nombre_empresa 
     */
    public void eliminarPracticasEmpresa(String nombre_empresa){
        PreparedStatement ps;        
        
        try{
            ps = connection.prepareStatement("DELETE FROM practicas WHERE nombre_empresa=?;");
            ps.setString(1, nombre_empresa);
            
            ps.execute();
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            
        }
    
    }
    /**
     * elimina todas las practicas solicitadas por un alumno especifico
     * @param id_alumno 
     */
    public void eliminarPracticasAlumno(long id_alumno){
        PreparedStatement ps;        
        
        try{
            ps = connection.prepareStatement("DELETE FROM practicas WHERE id_alumno=?;");
            ps.setLong(1, id_alumno);
            
            ps.execute();
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            
        }
    
    }
    /**
     * Devuelve las practicas solicitadas por un alumno en un diccionario
     * (nombre_empresa, preferencia)
     * @param id_alumno
     * @return 
     */
    public Map<String,Integer> obtenerNombreEmpresasSolicitadasPorPreferenciaAlumno(long id_alumno){
        Map<String,Integer>  nombresEmpresa = new HashMap<>(); 
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT nombre_empresa,preferencia FROM practicas where id_alumno=?;");
            ps.setLong(1, id_alumno);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
             
                nombresEmpresa.put(rs.getString("nombre_empresa"),rs.getInt("preferencia") );

            }
            
            return nombresEmpresa;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return null;
            
        }
    }
    /**
     * Devuelve solo las empresas a las que hayan solicitado practicas
     * @return 
     */
    public List<String> obtenerEmpresasConPracticas(){
        List<String> nombres_empresas= new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT DISTINCT nombre_empresa FROM practicas;");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                nombres_empresas.add(rs.getString("nombre_empresa"));
                    
            }
             
            return nombres_empresas;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return null;
            
        }
    }
    /**
     * Devuelve las practicas de una empresa y una preferencia especifica y las ordena por 
     * las notas de los alumnos que han seleccionado esas practicas
     * @param nombre_empresa
     * @param preferencia
     * @return 
     */
    public List<Practica> obtenerPracticasPorEmpresaPreferenciaOrdenadas(String nombre_empresa, int preferencia){
        // DEVUELVE LAS PRACTICAS QUE LOS ALUMNOS HAN HECHO EN UNA EMPRESA Y CON UNA PREFERENCIA ESPECIFICA
        // ORDENADAS POR NOTA MEDIA DEL ALUMNO
        
        List<Practica> practicas= new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM practicas WHERE nombre_empresa=? AND preferencia=? ORDER BY (SELECT alumno.nota_media FROM alumno WHERE alumno.id_alumno = practicas.id_alumno) DESC;");
            ps.setString(1, nombre_empresa);
            ps.setInt(2, preferencia);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Practica practica = new Practica();
                practica.setId_alumno(rs.getLong("id_alumno"));
                practica.setNombre_empresa(rs.getString("nombre_empresa"));
                practica.setPreferencia(rs.getInt("preferencia"));
                
                practicas.add(practica);
            }
            
        
            return practicas;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return null;
            
        }
    }
    /**
     * Devuelve todas las practicas
     * @return 
     */
    public List<Practica> listaPracticas(){
        List<Practica> practicas= new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM practicas;");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Practica practica = new Practica();
                practica.setId_alumno(rs.getLong("id_alumno"));
                practica.setNombre_empresa(rs.getString("nombre_empresa"));
                practica.setPreferencia(rs.getInt("preferencia"));
                
                practicas.add(practica);
            }
            
        
            return practicas;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return null;
            
        }
    }
    /**
     * Elimina una practica
     * @param practica 
     */
    public void eliminarPractica(Practica practica){
        PreparedStatement ps;        
        
        try{
            ps = connection.prepareStatement("DELETE FROM practicas WHERE id_alumno=? AND nombre_empresa=?;");
            ps.setLong(1, practica.getId_alumno());
            ps.setString(2, practica.getNombre_empresa());
            
            ps.execute();
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            
        }
    
    }
    /**
     * actualiza una practica
     * @param practica 
     */
    public void actualizarPractica(Practica practica){
        PreparedStatement ps;        
        
        try{
            ps = connection.prepareStatement("INSERT INTO practicas (id_alumno,nombre_empresa,preferencia) VALUES (?,?,?) ON DUPLICATE KEY UPDATE preferencia=?;");
            ps.setLong(1, practica.getId_alumno());
            ps.setString(2, practica.getNombre_empresa());
            ps.setInt(3, practica.getPreferencia());
            ps.setInt(4, practica.getPreferencia());
            ps.execute();
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            
        }
    }
}

