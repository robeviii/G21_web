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
import model.Solicitud;
import model.Tutor;
import util.DbUtil;
import util.Log;

/**
 *
 * @author victor
 */
public class SolicitudDao {
    
    private Connection connection;

    public SolicitudDao() {
        Log.logdb.info("Conectando para TutorDao...\n");
        connection = DbUtil.getConnection();
        Log.logdb.info("Conectado!\n");
    }

    
    public List<Solicitud> get(long id_alumno) {
        List<Solicitud> solicitudes = new ArrayList<Solicitud>();
        if (connection != null)
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from solicitud where id_alumno=?;");
                preparedStatement.setLong(1, id_alumno);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Solicitud solicitud = new Solicitud();
                    solicitud.setId_alumno(id_alumno);
                    solicitud.setId_practica(rs.getLong("id_practica"));
                    solicitud.setPreferencia(rs.getInt("preferencia"));
                   
                    solicitudes.add(solicitud);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e + "\n");            
            }
            return solicitudes;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd\n");
            return null;
        }
    }

    public void create(Solicitud solicitud) {
        if (connection != null)
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into solicitud values(?,?,?);");
                preparedStatement.setLong(1, solicitud.getId_alumno());
                preparedStatement.setLong(2, solicitud.getId_practica());
                preparedStatement.setLong(3, solicitud.getPreferencia());
                preparedStatement.executeUpdate();
                
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e + "\n");            
            }
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd\n");
        }
    }


}
