/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import config.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import models.Cliente;

/**
 *
 * @author David TL
 */
public class ClienteDAO implements IClienteDAO {

    @Override
    public boolean insertar(Cliente cliente) {
        String query = "INSERT INTO Cliente(nombre, dierccion, telefonos) VALUES(?,?,?) ";
        try(
            Connection cconn = ConexionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            )
            
        {
            
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDireccion());
            ps.setString(3, cliente.getTelefonos());
            
                return ps.executeUpdate() > 0;

                }catch (SQLException ex){
                    System.out.println("Error al intentar insertar el cliente" + ex.getMessage());
                    return false;
                }
        
        
                
    }
    

    @Override
    public Cliente obtenerPorID(int idCliente) {
        
        String query = "SELECT * FROM Cliente WHERE idCliente = ?";
        Cliente cliente = null;
        
        try(
                Connection conn = conn ConexionDB.getConnection();
                PrepareStatement ps = conn.prepareStatement(query)
                )
                {
                    ps.setInt(1,idCliente);
                }
    }

    @Override
    public List<Cliente> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(Cliente idCiente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
