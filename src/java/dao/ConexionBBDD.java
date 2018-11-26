/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author owa_7
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;
public class ConexionBBDD {

    private static ConexionBBDD UnicaConexion = null;
    private Connection Conex;

    private ConexionBBDD() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        //sin ?autoReconnect=true&useSSL=false no funciona
        String connectionUrl = "jdbc:mysql://localhost/elecciones_obb?autoReconnect=true&useSSL=false";
        Conex = DriverManager.getConnection(connectionUrl,"root","root");
    }

    public synchronized static ConexionBBDD GetConexion()
            throws ClassNotFoundException, SQLException {
        if (UnicaConexion == null) {
            UnicaConexion = new ConexionBBDD();
        }
        return UnicaConexion;
    }

    public Connection GetCon() {
        return Conex;
    }

    public void Destroy() throws SQLException {
        Conex.close();
    }
}
