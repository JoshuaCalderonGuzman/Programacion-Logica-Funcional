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
public class CContenedor {
    private Conexion conexion;
    public CContenedor(){
        this.conexion = new Conexion("TIENDA");
    }
    public List<Object[]> tablaInventario() {
        String query = "SELECT  i.Id, i.NombreCorto, i.Descripcion,i.Serie, i.Color,i.FechaAdquision,i.TipoAdquision,i.Observaciones,a.Nombre,a.Ubicacion "
                + "FROM INVENTARIO i JOIN AREAS a ON a.Id =i.Areas_id ;";
        List<Object[]> productos = new ArrayList<>();
        // Establecer la conexión a la base de datos
        try (Connection connection = conexion.conectar();
                //Cremos la consulta
             PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
           while (rs.next()) {
               //Obtenemos los datos y los metemos en venta
                Object[] producto = new Object[]{
                    rs.getInt("Id"),
                    rs.getString("NombreCorto"),
                    rs.getString("Descripcion"),
                    rs.getString("Serie"),
                    rs.getString("Color"),
                    rs.getDate("FechaAdquision"),
                    rs.getString("TipoAdquision"),
                    rs.getString("Observaciones"),
                    rs.getString("Nombre"),
                    rs.getString("Ubicacion")
                };
                //Ayadimos el objeto venta al array
                productos.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productos; 
    }
    
    public void Eliminar(int id){
        try (Connection conn = conexion.conectar()) {
            // Consulta para eliminar el cliente por su nobre
            String consulta = "DELETE FROM INVENTARIO WHERE Id = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                // Establecer el parámetro de la consulta (Nombre del Cliente)
                pstmt.setInt(1, id);  
                // Ejecutar la consulta de eliminación
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Producto eliminado exitosamente.");
                } else {
                    System.out.println("No se encontró el producto para eliminar.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar eliminar el producto: " + e.getMessage());
        }
    }
}
