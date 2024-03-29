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
    /**
     * Crea un Dao de alumno
     */
    public AlumnoDao() {
        Log.logdb.info("Conectando para AlumnoDao...\n");
        connection = DbUtil.getConnection();
        Log.logdb.info("Conectado!\n");
    }
    /**
     * devuelve un alumno por su id
     * @param id
     * @return 
     */
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
                    alumno.setNombre_empresa_practicas(rs.getString("nombre_empresa_practicas"));
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
    /**
     * asigna una empresa al alumno con ese id 
     * @param id_alumno
     * @param nombre_empresa 
     */
    public void asignarEmpresa(long id_alumno, String nombre_empresa){
        PreparedStatement ps;        
        
        try{
            ps = connection.prepareStatement("UPDATE alumno SET nombre_empresa_practicas=? WHERE id_alumno=?;");
            ps.setString(1, nombre_empresa);
            ps.setLong(2, id_alumno);
            ps.execute();
            
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            
        }
    }
    /**
     * devuelve un alumno con ese email
     * @param email
     * @return 
     */
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
                    alumno.setNombre_empresa_practicas(rs.getString("nombre_empresa_practicas"));
                  
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
    /**
     * devuelve todos los alumnos con ese tutor
     * @param id_tutor
     * @return 
     */
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
                alumno.setNombre_empresa_practicas(rs.getString("nombre_empresa_practicas"));
                
                lista.add(alumno);
            }
            
            return lista;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return null;
            
        }
    }
    /**
     * actualiza la nota del alumno 
     * @param alumno
     * @return 
     */
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
    /**
     * actualiza el informe del alumno
     * @param alumno
     * @return 
     */
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
    
    
}
