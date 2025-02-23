/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class CInventario {
     private Conexion conexion;
     
        public CInventario(){
        this.conexion = new Conexion("TIENDA");
    }
        
    
    public List<String> Areas(){
            List<String> areas = new ArrayList<>();
            try (Connection conn = conexion.conectar()) {
            //Cremos la consulta
            String consulta = "SELECT nombre  FROM AREAS";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    //Si debuelve el resultado se usa rs.next() para mover a la sigiente fila 
                    //y se guarda el resultado en una variable
                    while (rs.next()) {
                         String area=rs.getString("nombre");
                         areas.add(area);
                    }
                }
            }
             //Si hay error devuelve un mensaje
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener las areas: " + e.getMessage());
        }
            return areas;
    }
    
    public int idArea(String nombre){
        int idArea=0;
        try (Connection conn = conexion.conectar()) {
            //Cremos la consulta
            String consulta = "SELECT Id  FROM AREAS where Nombre=?;";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                    pstmt.setString(1, nombre);
                try (ResultSet rs = pstmt.executeQuery()) {
                    //Si debuelve el resultado se usa rs.next() para mover a la sigiente fila 
                    //y se guarda el resultado en una variable
                    if (rs.next()) {
                          idArea=rs.getInt("Id");
                    }
                }
            }
             //Si hay error devuelve un mensaje
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener la ubicacion: " + e.getMessage());
        }
        return idArea;
    }
    
    
    public void add(String Nombre, String Descripcion, String Serie, String Fecha,String Color,String TipoAd,String Observaciones,int IdA) {
        try (Connection conn = conexion.conectar()) {
            // Inserción de los datos en las columnas especificadas de la tabla INVENTARIO
            String consulta = "INSERT INTO INVENTARIO (NombreCorto, Descripcion, Serie, Color,FechaAdquision,TipoAdquision,Observaciones,Areas_id) VALUES (?, ?, ?, ?, ?,?,?,?);";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                // Establecer los parámetros de la consulta
                pstmt.setString(1, Nombre); 
                pstmt.setString(2, Descripcion);        
                pstmt.setString(3, Serie);         
                pstmt.setString(4, Color);         
                pstmt.setString(5, Fecha);
                pstmt.setString(6, TipoAd);
                pstmt.setString(7, Observaciones);
                pstmt.setInt(8,IdA );

                // Ejecutar la consulta de inserción
                pstmt.executeUpdate();

                System.out.println("Producto agregado exitosamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar agregar el Producto: " + e.getMessage());
        }
    }
     
    
    
    
}
