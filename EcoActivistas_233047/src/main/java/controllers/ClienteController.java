/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author David TL
 */
public class ClienteController implements IClienteController {

    @Override
    public boolean agregar(String nombre, String direccion, String telefonos) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;           
        }
        if (direccion == null || nombre.trim().isEmpty()) {
            return false;   
        }
        if (telefonos == null || nombre.trim().isEmpty()) {
            return false;
            
        }        
      
    }
    
    
}
