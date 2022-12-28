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
import model.Tutor;
import util.DbUtil;
import util.Log;

/**
 *
 * @author victor
 */
public class TutorDao implements Dao<Tutor>{
    
    private Connection connection;

    public TutorDao() {
        Log.logdb.info("Conectando para TutorDao...\n");
        connection = DbUtil.getConnection();
        Log.logdb.info("Conectado!\n");
    }

    
    @Override
    public Tutor get(String email) {
        Tutor tutor = new Tutor();
        if (connection != null)
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from tutor where email=?;");
                preparedStatement.setString(1, email);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    tutor.setEmail(email);
                    tutor.setNombre(rs.getString("nombre"));
                    tutor.setApellido(rs.getString("apellido"));
                    tutor.setPassword(rs.getString("password"));
                }

            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e + "\n");
            }
            return tutor;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd\n");
            return null;
        }
    }

    @Override
    public List<Tutor> getAll() {
        List<Tutor> tutores = new ArrayList<Tutor>();
        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from tutor;");
                while (rs.next()) {
                    Tutor tutor = new Tutor();
                    tutor.setEmail(rs.getString("email"));
                    tutor.setNombre(rs.getString("nombre"));
                    tutor.setApellido(rs.getString("apellido"));
                    tutor.setPassword(rs.getString("password"));
                
        
                    
                    tutores.add(tutor);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e + "\n");            
            }
            return tutores;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd\n");
            return null;
        }
    }

    @Override
    public void create(Tutor t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Tutor t, String[] params) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Tutor t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
