package com.mycompany.empresajpa.dao;

import com.mycompany.empresajpa.entity.Empleado;
import jakarta.persistence.EntityManager;
import java.util.List;

public interface IEmpleadoDAO {
    void insertar(EntityManager em, Empleado empleado);
    void actualizar(EntityManager em, Empleado empleado);
    void eliminar(EntityManager em, Long id);
    Empleado buscar(EntityManager em, Long id);
    List<Empleado> listar(EntityManager em);
}
