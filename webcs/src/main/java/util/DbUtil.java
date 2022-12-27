/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private static Connection connection = null;

    public static Connection getConnection() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/userdb?useTimezone=true&serverTimezone=Europe/Madrid";
        String user = "root";
        String password = "webcs";
        Log.logdb.info("Entramos a conectar con la BBDD");
        if (connection != null) {
            Log.logdb.info("Ya hay una conexion");
            return connection;
        } else {
            try {
                Log.logdb.info("Creamos una nueva conexion");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                Log.logdb.info("Finalizamos config db");
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
