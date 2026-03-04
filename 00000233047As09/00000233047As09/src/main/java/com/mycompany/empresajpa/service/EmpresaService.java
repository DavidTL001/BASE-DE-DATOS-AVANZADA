package com.mycompany.empresajpa.service;

import com.mycompany.empresajpa.dao.EmpleadoDAO;
import com.mycompany.empresajpa.entity.Empleado;
import com.mycompany.empresajpa.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class EmpresaService {

    private final EmpleadoDAO empleadoDAO = new EmpleadoDAO();

    public void aumentarSalario(Long id, Double porcentaje) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            Empleado empleado = empleadoDAO.buscar(em, id);

            if (empleado == null)
                throw new RuntimeException("Empleado no encontrado con id=" + id);
            if (porcentaje == null || porcentaje <= 0)
                throw new RuntimeException("Porcentaje inválido");

            double salarioAnterior = empleado.getSalario();
            double nuevoSalario = salarioAnterior + (salarioAnterior * porcentaje / 100.0);
            empleado.setSalario(nuevoSalario);
            empleadoDAO.actualizar(em, empleado);

            em.getTransaction().commit();
            System.out.printf("Salario actualizado | id=%d | %.2f -> %.2f (+%.1f%%)%n",
                    id, salarioAnterior, nuevoSalario, porcentaje);

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error en aumentarSalario: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
