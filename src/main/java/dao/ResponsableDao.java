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
import model.Responsable;
import util.DbUtil;
import util.Log;

/**
 *
 * @author victor
 */
public class ResponsableDao{
    
    private Connection connection;

    public ResponsableDao() {
        Log.logdb.info("Conectando para ResponsableDao...\n");
        connection = DbUtil.getConnection();
        Log.logdb.info("Conectado!\n");
    }

    
    
    public Responsable obtenerPorEmail(String email) {
        Responsable responsable = new Responsable();
        if (connection != null)
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from responsable where email=?;");
                preparedStatement.setString(1, email);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    responsable.setEmail(email);
                    responsable.setNombre(rs.getString("nombre"));
                    responsable.setApellido(rs.getString("apellido"));
                    responsable.setPassword(rs.getString("password"));
                    responsable.setId(rs.getLong("id_responsable"));

                    return responsable;
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

    public List<Responsable> listaResponsables() {
        List<Responsable> responsables = new ArrayList<Responsable>();
        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from responsable;");
                while (rs.next()) {
                    Responsable responsable = new Responsable();
                    responsable.setEmail(rs.getString("email"));
                    responsable.setNombre(rs.getString("nombre"));
                    responsable.setId(rs.getLong("id_responsable"));
                    responsable.setPassword(rs.getString("password"));
                
        
                    
                    responsables.add(responsable);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e + "\n");            
            }
            return responsables;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd\n");
            return null;
        }
    }

}
