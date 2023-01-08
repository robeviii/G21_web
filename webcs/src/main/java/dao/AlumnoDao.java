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
public class AlumnoDao implements Dao<Alumno>{
    
    private Connection connection;

    public AlumnoDao() {
        Log.logdb.info("Conectando para AlumnoDao...\n");
        connection = DbUtil.getConnection();
        Log.logdb.info("Conectado!\n");
    }

    
    @Override
    public Alumno get(String email) {
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
                    alumno.setId(rs.getLong("id_alumno"));
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

    @Override
    public List<Alumno> getAll() {
        List<Alumno> alumnos = new ArrayList<Alumno>();
        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from alumno;");
                while (rs.next()) {
                    Alumno alumno = new Alumno();
                    alumno.setEmail(rs.getString("email"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setDni(rs.getString("dni"));
                    alumno.setId(rs.getLong("id_alumno"));
                    alumno.setId_tutor(rs.getLong("id_tutor"));
                    alumno.setNota_media(rs.getDouble("nota_media"));
                    alumno.setPassword(rs.getString("password"));
                
                    alumnos.add(alumno);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e + "\n");            
            }
            return alumnos;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd\n");
            return null;
        }
    }

    @Override
    public void create(Alumno t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Alumno t, String[] params) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Alumno t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
