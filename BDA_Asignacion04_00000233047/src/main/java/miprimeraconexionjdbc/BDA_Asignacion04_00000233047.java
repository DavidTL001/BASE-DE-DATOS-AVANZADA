/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package miprimeraconexionjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author darkm
 */
public class BDA_Asignacion04_00000233047 {
   
    private static final String URL = "jdbc:mysql://localhost:3306/MyDatabase";
    private static final String user = "root";
    private static final String password = "Sql.introduce.64";
   
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, user, password);
    }
   
    public static void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS clientes ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "nombre VARCHAR(100) NOT NULL,"
                + "password VARCHAR(100) NOT NULL)";
       
        try (
                Connection con = getConnection();
                Statement st = con.createStatement()) {
            st.execute(sql);
            System.out.println("Tabla creada con exito");
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    
    public static void  obtenerClientes() {
        try (
                Connection con = getConnection();
                Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery("SELECT id, nombre FROM clientes")
                ) {
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                
                System.out.println(id + " | " + nombre);
            }
            
        } catch  (SQLException e ){
            e.printStackTrace();
        }
                
         
    }

    public static void main(String[] args) throws SQLException {
        crearTabla();
    }
}