package com.mycompany.empresajpa.dao;

import com.mycompany.empresajpa.entity.Empleado;
import jakarta.persistence.EntityManager;
import java.util.List;

public class EmpleadoDAO implements IEmpleadoDAO {

    @Override
    public void insertar(EntityManager em, Empleado empleado) {
        em.persist(empleado);
    }

    @Override
    public void actualizar(EntityManager em, Empleado empleado) {
        em.merge(empleado);
    }

    @Override
    public void eliminar(EntityManager em, Long id) {
        Empleado empleado = em.find(Empleado.class, id);
        if (empleado != null) {
            em.remove(empleado);
        }
    }

    @Override
    public Empleado buscar(EntityManager em, Long id) {
        return em.find(Empleado.class, id);
    }

    @Override
    public List<Empleado> listar(EntityManager em) {
        return em.createQuery("SELECT e FROM Empleado e ORDER BY e.id", Empleado.class)
                 .getResultList();
    }
}
