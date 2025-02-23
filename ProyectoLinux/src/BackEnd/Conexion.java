/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author s2212
 */
public class Conexion {
    String bd;
    String url = "jdbc:mysql://192.168.1.11:3306/";
    String user = "Juan";
    String password = "Ju@an123";
    String driver = "com.mysql.cj.jdbc.Driver";
    
    Connection cx;

    public Conexion(String bd) {
    this.bd = bd;
    }
    
    public Connection conectar(){
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url+bd, user, password);
            System.out.println("SE CONECTO A LA BASE DE DATOS: " + bd);
        } catch (ClassNotFoundException | SQLException ex) {
            
            System.out.println("NO SE CONECTO CON LA BASE DE DATOS");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return cx;
    }
    
    public void desconectar(){
        try {
            cx.close();
            System.out.println("LA CONEXION SE DESCONECTO CON EXITO");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
