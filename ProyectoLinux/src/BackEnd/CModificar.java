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
public class CModificar {
      private Conexion conexion;
     
        public CModificar(){
        this.conexion = new Conexion("TIENDA");
    }
        
   public String[] select(int id) {
        // Inicializamos el arreglo que contendrá los detalles del producto
        String[] Product = new String[8];  // 8 posiciones para cada dato

        try (Connection conn = conexion.conectar()) {
            String consulta = "SELECT  i.NombreCorto, i.Descripcion,i.Serie, i.Color,i.FechaAdquision,i.TipoAdquision,i.Observaciones,  a.Nombre \n" +
                                            "FROM INVENTARIO i JOIN AREAS a ON a.Id= i.Areas_id where i.id=?;";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {

                pstmt.setInt(1, id);  

                try (ResultSet rs = pstmt.executeQuery()) {
                    // Si hay resultados, guardamos cada dato en su posición correspondiente
                    if (rs.next()) {
                        Product[0] = rs.getString("NombreCorto");         
                        Product[1] = rs.getString("Descripcion");
                        Product[2] = rs.getString("Serie");
                        Product[3] = rs.getString("Color");
                        Product[4] = rs.getString("FechaAdquision");
                        Product[5] = rs.getString("TipoAdquision");
                        Product[6] = rs.getString("Observaciones");
                        Product[7] = rs.getString("Nombre");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener el cliente: " + e.getMessage());
        }

        return Product;
    }
   
   public void update(String nombre,String descripcion,String serie,String color,String fecha,String ta,String obsevaciones, int Aid, int Id) {
    // Convertir el género a 'M' o 'F' según el valor recibido


    try (Connection conn = conexion.conectar()) {
       

        // Si el cliente existe, procedemos a actualizar los datos
        String consulta = "UPDATE INVENTARIO i\n" +
                                       "JOIN AREAS a ON i.Areas_id = a.Id\n" +
                                       "SET  NombreCorto=?, i.Descripcion=?, i.Serie=?, i.Color=?, i.FechaAdquision=?, i.TipoAdquision=?,i.Observaciones=?,i.Areas_id=?\n" +
                                        "WHERE i.Id=?;";

        try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
            // Establecer los parámetros de la consulta de actualización
            pstmt.setString(1, nombre);  
             pstmt.setString(2, descripcion);  
             pstmt.setString(3, serie); 
             pstmt.setString(4, color); 
              pstmt.setString(5, fecha); 
              pstmt.setString(6, ta); 
              pstmt.setString(7, obsevaciones); 
              pstmt.setInt(8, Aid); 
            pstmt.setInt(9, Id);      
 // Nombre del cliente (criterio de búsqueda para la actualización)

            // Ejecutar la consulta de actualización
            int filasActualizadas = pstmt.executeUpdate();
            if (filasActualizadas > 0) {
                // Si se actualizó al menos un registro
                System.out.println("Cliente editado exitosamente.");
            } else {
                // Si no se encontró el cliente
                System.out.println("Error: No se encontró un cliente con el nombre especificado.");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al intentar editar el cliente: " + e.getMessage());
    }
}
}
