/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Empresa;
import util.DbUtil;
import util.Log;

/**
 *
 * @author 34646
 */
public class EmpresaDAO {
    
    Connection connection;
    
    public EmpresaDAO(){
        Log.logdb.info("Conectando para TutorDao...\n");
        connection = DbUtil.getConnection();
        Log.logdb.info("Conectado!\n");
        
    }
    
    public List<Empresa> listaempresa(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        List<Empresa> lista = new ArrayList<>();
        
        try{
            ps = connection.prepareStatement("SELECT nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, idtutor FROM empresa");
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                String nombre = rs.getString("nombre_e");
                String direccion = rs.getString("direccion");
                String ambito = rs.getString("ambito");
                String web = rs.getString("web");
                String telefono = rs.getString("telefono");
                String nalumnos = rs.getString("nalumnos");
                String horario = rs.getString("horario");
                String duracion = rs.getString("duracion");
                int idtutor = rs.getInt("idtutor");
                
                Empresa empresa = new Empresa(idtutor,nombre,direccion,ambito,web,telefono,nalumnos,horario,duracion,idtutor);
                
                lista.add(empresa);
            }
            
            return lista;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return null;
            
        }
        
    }
    
    public Empresa mostrartEmpresa(String _nombre){
        
        PreparedStatement ps;
        ResultSet rs;
        Empresa empresa = null;
        
        try{
            ps = connection.prepareStatement("SELECT nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, idtutor FROM empresa WHERE nombre=?");
            ps.setString(1, _nombre);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                String nombre = rs.getString("nombre_e");
                String direccion = rs.getString("direccion");
                String ambito = rs.getString("ambito");
                String web = rs.getString("web");
                String telefono = rs.getString("telefono");
                String nalumnos = rs.getString("nalumnos");
                String horario = rs.getString("horario");
                String duracion = rs.getString("duracion");
                int idtutor = rs.getInt("idtutor");
                
                empresa = new Empresa(idtutor,nombre,direccion,ambito,web,telefono,nalumnos,horario,duracion,idtutor);
            }
            
            return empresa;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return null;
            
        }
        
        
        
    }
    
    public boolean insertar(Empresa empresa){
        PreparedStatement ps;        
        
        try{
            ps = connection.prepareStatement("INSERT INTO empresa (nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor) VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, empresa.getNombre());
            ps.setString(2, empresa.getDireccion());
            ps.setString(3, empresa.getAmbito());
            ps.setString(4, empresa.getWeb());
            ps.setString(5, empresa.getTelefono());
            ps.setString(6, empresa.getNalumnos());
            ps.setString(7, empresa.getHorario());
            ps.setString(8, empresa.getDuracion());
            ps.setInt(9, empresa.getId_tutor());
            ps.execute();
            
            return true;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return false;
            
        }
        
    }
    
    public boolean actualizar(Empresa empresa){
        
        PreparedStatement ps;        
        
        try{
            ps = connection.prepareStatement("UPDATE INTO empresa SET direccion=? ambito=? web=? telefono=? nalumnos=? horario=? duracion=? WHERE nombre_e=?");
            ps.setString(1, empresa.getDireccion());
            ps.setString(2, empresa.getAmbito());
            ps.setString(3, empresa.getWeb());
            ps.setString(4, empresa.getTelefono());
            ps.setString(5, empresa.getNalumnos());
            ps.setString(6, empresa.getHorario());
            ps.setString(7, empresa.getDuracion());
            ps.setString(8, empresa.getNombre());
            ps.execute();
            
            return true;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return false;
            
        }
        
    }
    
    public boolean eliminar(String _nombre){
        
        PreparedStatement ps;        
        
        try{
            ps = connection.prepareStatement("DELETE FROM empresa WHERE nombre_e=?");
            ps.setString(1, _nombre);
            ps.execute();
            
            return true;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return false;
            
        }
        
    }
    
}
