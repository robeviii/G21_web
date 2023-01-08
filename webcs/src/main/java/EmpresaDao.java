
import dao.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Empresa;
import util.DbUtil;
import util.Log;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author victor
 */
public class EmpresaDao implements Dao<Empresa>{
    
    private Connection connection;

    public EmpresaDao() {
        Log.logdb.info("Conectando para EmpresaDao...\n");
        connection = DbUtil.getConnection();
        Log.logdb.info("Conectado!\n");
    }

    
    @Override
    public Empresa get(String email) {
        Empresa empresa = new Empresa();
        if (connection != null)
        {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from empresa where email=?;");
                preparedStatement.setString(1, email);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    empresa.setNombre(rs.getString("nombre"));
                    empresa.setDireccion(rs.getString("direccion"));
                    empresa.setWeb(rs.getString("web"));
                    empresa.setTelefono(rs.getString("telefono"));
                    empresa.setId_tutor(rs.getLong("id_tutor"));


                    return empresa;
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
    public List<Empresa> getAll() {
        List<Empresa> empresas = new ArrayList<Empresa>();
        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from empresa;");
                while (rs.next()) {
                    Empresa empresa = new Empresa();
                    empresa.setNombre(rs.getString("nombre"));
                    empresa.setDireccion(rs.getString("direccion"));
                    empresa.setWeb(rs.getString("web"));
                    empresa.setTelefono(rs.getString("telefono"));
                    empresa.setId_tutor(rs.getLong("id_tutor"));

                    empresas.add(empresa);
                }
            } catch (SQLException e) {
                Log.logdb.error("SQL Exception: " + e + "\n");            
            }
            return empresas;
        }
        else
        {
            Log.logdb.error("No hay conexion con la bbdd\n");
            return null;
        }
    }

    @Override
    public void create(Empresa t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Empresa t, String[] params) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Empresa t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
