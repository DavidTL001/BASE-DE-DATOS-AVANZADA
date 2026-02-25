/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiendajpa_00000233047;

/**
 *
 * @author David TL 00000233047
 */
public class TiendaJPA_00000233047 {

    public static void main(String[] args) {
   ProductoDAO productoDAO = new ProductoDAO();
        /*
        Producto p1 = new Producto (0, "papita", 19.90);
        Producto p2 = new Producto (1, "galletas", 21.90);
        Producto p3 = new Producto (2, "CocaCola", 25.90);       
        Producto p4 = new Producto(3, "Gansito", 15.90);
        */
        Producto p = new Producto();
        p.setId(0);
        p.setNombre("papita");
        p.setPrecio(19.90);
        productoDAO.insertar(p);
        
        Producto p2 = new Producto();
        p2.setId(0);
        p2.setNombre("papita");
        p2.setPrecio(19.90);
        productoDAO.insertar(p);

        Producto p3 = new Producto();
        p3.setId(0);
        p3.setNombre("papita");
        p3.setPrecio(19.90);
        productoDAO.insertar(p);        
        
        Producto p4 = new Producto();
        p4.setId(0);
        p4.setNombre("papita");
        p4.setPrecio(19.90);
        productoDAO.insertar(p);
        
        Producto pbuscado = productoDAO.buscar(3);
        System.out.println("Producto encontrado" + pbuscado.getNombre());
        
        pbuscado.setPrecio(26.90);
        productoDAO.actualizar(p);
        
        productoDAO.eliminar(4);
     
    }
}
