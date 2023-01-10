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
public class EmpresaDao{
    
    Connection connection;
    
    public EmpresaDao(){
        Log.logdb.info("Conectando para EmpresaDao...\n");
        connection = DbUtil.getConnection();
        Log.logdb.info("Conectado!\n");
        
    }
    
    public List<Empresa> listaEmpresa(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        List<Empresa> lista = new ArrayList<>();
        
        try{
            ps = connection.prepareStatement("SELECT * FROM empresa");
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                Empresa empresa = new Empresa();
                
                empresa.setNombre(rs.getString("nombre_e"));
                empresa.setDireccion(rs.getString("direccion"));
                empresa.setAmbito(rs.getString("ambito"));
                empresa.setWeb(rs.getString("web"));
                empresa.setTelefono(rs.getString("telefono"));
                empresa.setNalumnos(rs.getString("nalumnos"));
                empresa.setHorario(rs.getString("horario"));
                empresa.setDuracion(rs.getString("duracion"));
                empresa.setId_tutor(rs.getInt("id_tutor"));

                lista.add(empresa);
            }
            
            return lista;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return null;
            
        }
        
    }
    public Integer obtenerMaxAlumnos(String nombreEmpresa){
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            ps = connection.prepareStatement("SELECT nalumnos FROM empresa WHERE nombre_e=?");
            ps.setString(1, nombreEmpresa);
            rs = ps.executeQuery();
            System.out.println(rs.toString());
            if (rs.next()){
                return Integer.parseInt(rs.getString("nalumnos"));
            }
             
        } catch(SQLException e){

               System.out.println(e.toString());
               

           }
        return null;
    }
    public Empresa mostrarEmpresa(String _nombre){
        
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            ps = connection.prepareStatement("SELECT nombre_e, direccion, ambito, web, telefono, nalumnos, horario, duracion, id_tutor FROM empresa WHERE nombre_e=?");
            ps.setString(1, _nombre);
            rs = ps.executeQuery();

            Empresa empresa = new Empresa();

            empresa.setNombre(rs.getString("nombre_e"));
            empresa.setDireccion(rs.getString("direccion"));
            empresa.setAmbito(rs.getString("ambito"));
            empresa.setWeb(rs.getString("web"));
            empresa.setTelefono(rs.getString("telefono"));
            empresa.setNalumnos(rs.getString("nalumnos"));
            empresa.setHorario(rs.getString("horario"));
            empresa.setDuracion(rs.getString("duracion"));
            empresa.setId_tutor(rs.getInt("id_tutor"));

            
            
            return empresa;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return null;
            
        }
        
        
        
    }
    
   
    public void insertar(Empresa empresa) {
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
            ps.setString(9,String.valueOf(empresa.getId_tutor()));
            ps.execute();
            
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            
        }
    }

   
    public void actualizar(Empresa empresa, String[] params) {
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
            
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            
        }
    }

    public void eliminar(Empresa empresa) {
        PreparedStatement ps;        
        
        try{
            ps = connection.prepareStatement("DELETE FROM empresa WHERE nombre_e=?");
            ps.setString(1, empresa.getNombre());
            ps.execute();
            
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            
        }
    }
    
}
