/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que establece la conexion con la base de datos
 * @author victor
 */

public class DbUtil {
    
    private static Connection connection = null;
    /**
     * Crea una conexion con la base de datos de Docker(mariadb:3306)
     * @return 
     */
    public static Connection getConnection() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://mariadb:3306/ingenieros_al_peso?useTimezone=true&serverTimezone=Europe/Madrid";
        String user = "root";
        String password = "webcs";
        Log.logdb.info("Conectando a BBDD...");
        if (connection != null) {
            Log.logdb.info("Ya existe una conexion.");
            return connection;
        } else {
            try {
                Log.logdb.info("Creando nueva conexion...");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                Log.logdb.info("Conexion creada!");
            } catch (ClassNotFoundException e) {
                Log.logdb.error("Error de conexion: " + e);
            } catch (SQLException e) {
                Log.logdb.error("Error de SQL: " + e);
            } catch (Exception e) {
                Log.logdb.error("Error general DB: " + e);
            }

            return connection;
        }
    }
}
