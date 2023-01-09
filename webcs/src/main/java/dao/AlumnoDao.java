/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Alumno;
import util.DbUtil;
import util.Log;

/**
 *
 * @author victor
 */
public class AlumnoDao{
    
    private Connection connection;

    public AlumnoDao() {
        Log.logdb.info("Conectando para AlumnoDao...\n");
        connection = DbUtil.getConnection();
        Log.logdb.info("Conectado!\n");
    }

    public Alumno obtener(long id) {
        Alumno alumno = new Alumno();
        if (connection != null)
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from alumno where id_alumno=?;");
                preparedStatement.setLong(1, id);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    alumno.setEmail(rs.getString("email"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setDni(rs.getString("dni"));
                    alumno.setId(id);
                    alumno.setNota_practica(rs.getInt("nota_practica"));
                    alumno.setInforme(rs.getString("informe"));
                    alumno.setId_tutor(rs.getLong("id_tutor"));
                    alumno.setNota_media(rs.getDouble("nota_media"));
                    alumno.setPassword(rs.getString("password"));
                    return alumno;
                }
                
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e + "\n");
            }
            return null;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd\n");
            return null;
        }    
    }
    
    public Alumno obtenerPorEmail(String email) {
        Alumno alumno = new Alumno();
        if (connection != null)
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from alumno where email=?;");
                preparedStatement.setString(1, email);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    
                    alumno.setEmail(email);
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setDni(rs.getString("dni"));
                    alumno.setNota_practica(rs.getInt("nota_practica"));
                    alumno.setInforme(rs.getString("informe"));
                    alumno.setId_tutor(rs.getLong("id_tutor"));
                    alumno.setNota_media(rs.getDouble("nota_media"));
                    alumno.setPassword(rs.getString("password"));
                    alumno.setId(rs.getLong("id_alumno"));
                   
                    return alumno;
                }
                
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e + "\n");
            }
            return null;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd\n");
            return null;
        }
    }

    public List<Alumno> listaAlumnos(long id_tutor) {
        PreparedStatement ps;
        ResultSet rs;
        
        List<Alumno> lista = new ArrayList<Alumno>();
        
        try{
            ps = connection.prepareStatement("SELECT * from alumno where id_tutor=?;");
            ps.setLong(1, id_tutor);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                Alumno alumno = new Alumno();
               
                alumno.setEmail(rs.getString("email"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setDni(rs.getString("dni"));
                alumno.setNota_practica(rs.getInt("nota_practica"));
                alumno.setInforme(rs.getString("informe"));
                alumno.setId_tutor(rs.getLong("id_tutor"));
                alumno.setNota_media(rs.getDouble("nota_media"));
                alumno.setPassword(rs.getString("password"));
                alumno.setId(rs.getLong("id_alumno"));
                
                lista.add(alumno);
            }
            
            return lista;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return null;
            
        }
    }
    public boolean actualizarNota(Alumno alumno){
        
        PreparedStatement ps;        
        
        try{
            ps = connection.prepareStatement("UPDATE alumno SET nota_practica=? WHERE id_alumno=?");
            ps.setDouble(1, alumno.getNota_practica());
            ps.setLong(2, alumno.getId());
            ps.execute();
            
            return true;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return false;
            
        }
        
    }
    
    public boolean actualizarInforme(Alumno alumno){
        
        PreparedStatement ps;        
        
        try{
            ps = connection.prepareStatement("UPDATE alumno SET informe=? WHERE id_alumno=?");
            ps.setString(1, alumno.getInforme());
            ps.setLong(2, alumno.getId());
            ps.execute();
            
            return true;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return false;
            
        }
        
    }
    
    public List<Alumno> listaAlumnoEmpresa(int _idtutor){
        
        PreparedStatement ps;
        ResultSet rs;
        Alumno alumno = null;
        
        List<Alumno> lista = new ArrayList<>();
        
        try{
            ps = connection.prepareStatement("SELECT * from alumno WHERE id_tutor_al=?");
            ps.setInt(1, _idtutor);
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
}
