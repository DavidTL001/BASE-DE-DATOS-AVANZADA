/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import java.util.List;
import models.Cliente;

/**
 *
 * @author David TL
 */
public interface IClienteDAO {
    
   boolean insertar (Cliente cliente);
   Cliente obtenerPorID (int idCliente);
   List<Cliente> obtenerTodos ();
   boolean actualizar (Cliente cliente);
   boolean eliminar (Cliente idCiente);
   
}
