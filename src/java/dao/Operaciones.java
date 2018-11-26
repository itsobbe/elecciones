/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Votante;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.ApplicationException;
import java.time.LocalDate;
/**
 *
 * @author owa_7
 */
public class Operaciones {
    
    public boolean insertarVotante(Connection conexion,Votante votante) throws SQLException{
        try {
            String sql="insert into votante values(null,?,AES_ENCRYPT(?,'oualid'),?,?,?,?,'N','votante')";
        PreparedStatement prestm=conexion.prepareStatement(sql);
        prestm.setString(3, votante.getNombre());
        prestm.setString(4, votante.getApellidos());
        prestm.setString(2, votante.getContraseña());
        prestm.setString(5,votante.getDomicilio());
        prestm.setString(1, votante.getNif());
        Date fecha=java.sql.Date.valueOf(votante.getFechaNac());
        prestm.setDate(6, fecha);
        int resultado=prestm.executeUpdate();
        if (resultado==1) {
            return true;
        }
        
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public Votante inicioSesion(String nif,String contraseña,Connection conexion) throws SQLException, ApplicationException{
         try {
            PreparedStatement pre=conexion.prepareStatement("SELECT * FROM votante WHERE nif=? AND AES_DECRYPT(password,'oualid')=?");
            pre.setString(1, nif);
            pre.setString(2, contraseña);
            ResultSet rs=pre.executeQuery();
             if (rs.next()) {
                 return new Votante(rs.getString("nombre"),rs.getString("apellidos"),rs.getString("domicilio"),LocalDate.parse(rs.getString("fechaNac")),rs.getString("nif"),rs.getString("rol"),rs.getString("votado"));
             }else  throw new ApplicationException("Error buscando el usuario", 0, "Usuario no encontrado");
        } catch (SQLException e) {
            throw new ApplicationException(e.getMessage(), e.getErrorCode(), e.getSQLState());
        }
    }
    
    public ArrayList<Votante> listadoCenso(Connection conexion){
        ArrayList<Votante> array=new ArrayList();
        try {
            PreparedStatement pre=conexion.prepareStatement("SELECT * FROM votante");
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                array.add(new Votante(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("domicilio"), LocalDate.parse(rs.getString("fechaNac")),rs.getString("nif"),rs.getString("rol"),rs.getString("votado")));
//            array.add(new Votante(rs.getString("nif"),rs.getString("votado"),rs.getString("rol")));
            }
            
        } catch (SQLException e) {
        }
        return array;
    }
    
    public Votante devuelveVotante(String nif,Connection conexion) throws ApplicationException{
        try {
            PreparedStatement pre=conexion.prepareStatement("select * from votante where nif=?");
            pre.setString(1, nif);
            ResultSet rs=pre.executeQuery();
            
            while(rs.next()){
                return new Votante(rs.getString("nif"), rs.getString("votado"), rs.getString("rol"));
            }
        } catch (SQLException e) {
            throw new ApplicationException("Error devolver objeto votante", e.getErrorCode(), e.getMessage());
        }
        return null;
    }
    public boolean darBajaVotante(Votante votante,Connection conexion) throws ApplicationException{
        String nif=votante.getNif();
        try {
            PreparedStatement pre=conexion.prepareStatement("DELETE FROM votante where nif=?");
            pre.setString(1, nif);
            int resultado=pre.executeUpdate();
            if (resultado == 1) {
                return true;
            }else return false;
        } catch (SQLException e) {
            throw new ApplicationException("Error en baja", e.getErrorCode(), e.getMessage());
        }
        
    }
    
    public Boolean cambioDatos(Votante votante,Connection conexion) throws SQLException,ApplicationException{
        try {
            PreparedStatement pre=conexion.prepareStatement("UPDATE votante SET password=AES_ENCRYPT(?,'oualid'),nombre=?,apellidos=?,domicilio=?,fechaNac=? WHERE nif=?");
            pre.setString(1, votante.getContraseña());
            pre.setString(2, votante.getNombre());
            pre.setString(3, votante.getApellidos());
            pre.setString(4, votante.getDomicilio());
            pre.setDate(5, java.sql.Date.valueOf(votante.getFechaNac()));
            pre.setString(6, votante.getNif());
            int resultado=pre.executeUpdate();
            if (resultado!=1) {
                throw new ApplicationException("Error en actualización", 0, "No se ha podido actualizar");
            }
            return true;
        } catch (SQLException e) {
            throw new ApplicationException("Error en actualización", e.getErrorCode(), e.getMessage());
        }
       
    }
    
}
