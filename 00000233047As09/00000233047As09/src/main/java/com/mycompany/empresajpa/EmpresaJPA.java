package com.mycompany.empresajpa;

import com.mycompany.empresajpa.dao.EmpleadoDAO;
import com.mycompany.empresajpa.dao.IEmpleadoDAO;
import com.mycompany.empresajpa.entity.Empleado;
import com.mycompany.empresajpa.entity.EstatusEmpleado;
import com.mycompany.empresajpa.service.EmpresaService;
import com.mycompany.empresajpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;

public class EmpresaJPA {

    public static void main(String[] args) {

        IEmpleadoDAO dao = new EmpleadoDAO();
        EmpresaService service = new EmpresaService();

        Empleado emp1 = new Empleado(
                "David Tirado", "david@gmail.com", 15000.0,
                EstatusEmpleado.ACTIVO, LocalDate.of(2003, 5, 23));

        Empleado emp2 = new Empleado(
                "Juan carlos", "juann@hotmail.com", 32000.0,
                EstatusEmpleado.ACTIVO, LocalDate.of(2010, 6, 1));

        Empleado emp3 = new Empleado(
                "Alan Perez", "alan@outlook.com", 20500.0,
                EstatusEmpleado.INACTIVO, LocalDate.of(2020, 10, 10));

        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            dao.insertar(em, emp1);
            dao.insertar(em, emp2);
            dao.insertar(em, emp3);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
        } finally {
            em.close();
        }

        em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Empleado aModificar = dao.buscar(em, emp2.getId());
            aModificar.setNombre("Carlos A. López Martínez");
            aModificar.setEstatus(EstatusEmpleado.INACTIVO);
            dao.actualizar(em, aModificar);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
        } finally {
            em.close();
        }

        service.aumentarSalario(emp1.getId(), 15.0);

        em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            dao.eliminar(em, emp3.getId());
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
        } finally {
            em.close();
        }

        JpaUtil.close();
    }

}