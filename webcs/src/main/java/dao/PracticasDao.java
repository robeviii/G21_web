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
    
    public PracticasDao(){
        Log.logdb.info("Conectando para PracticasDao...\n");
        connection = DbUtil.getConnection();
        Log.logdb.info("Conectado!\n");
        
    }

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

