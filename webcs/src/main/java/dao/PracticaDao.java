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
import model.Practica;
import util.DbUtil;
import util.Log;

/**
 *
 * @author victor
 */
public class PracticaDao implements Dao<Practica>{
    
    private Connection connection;

    public PracticaDao() {
        Log.logdb.info("Conectando para PracticasDao...\n");
        connection = DbUtil.getConnection();
        Log.logdb.info("Conectado!\n");
    }

    
    @Override
    public Practica get(String email) {
        Practica practica = new Practica();
        if (connection != null)
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from practica where email=?;");
                preparedStatement.setString(1, email);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    practica.setDescripcion(rs.getString("descripcion"));
                    practica.setNombre(rs.getString("nombre"));
                    practica.setDuracion(rs.getInt("duracion"));
                    practica.setId_empresa(rs.getLong("id_empresa"));
                    practica.setId_tutor(rs.getLong("id_tutor"));
                    practica.setPlazas(rs.getInt("plazas"));
        
                    

                    return practica;
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
    public List<Practica> getAll() {
        List<Practica> practicas = new ArrayList<Practica>();
        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from practica;");
                while (rs.next()) {
                    Practica practica = new Practica();
                    practica.setDescripcion(rs.getString("descripcion"));
                    practica.setNombre(rs.getString("nombre"));
                    practica.setDuracion(rs.getInt("duracion"));
                    practica.setId_empresa(rs.getLong("id_empresa"));
                    practica.setId_tutor(rs.getLong("id_tutor"));
                    practica.setPlazas(rs.getInt("plazas"));
        
                    
                    practicas.add(practica);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e + "\n");            
            }
            return practicas;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd\n");
            return null;
        }
    }

    @Override
    public void create(Practica t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Practica t, String[] params) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Practica t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


