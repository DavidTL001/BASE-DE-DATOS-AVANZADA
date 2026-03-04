package com.mycompany.empresajpa.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "empleados",
       uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "salario", nullable = false)
    private Double salario;

    @Enumerated(EnumType.STRING)
    @Column(name = "estatus", nullable = false, length = 10)
    private EstatusEmpleado estatus;

    @Column(name = "fecha_contratacion", nullable = false)
    private LocalDate fechaContratacion;

    public Empleado() {}

    public Empleado(String nombre, String email, Double salario,
                    EstatusEmpleado estatus, LocalDate fechaContratacion) {
        this.nombre = nombre;
        this.email = email;
        this.salario = salario;
        this.estatus = estatus;
        this.fechaContratacion = fechaContratacion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Double getSalario() { return salario; }
    public void setSalario(Double salario) { this.salario = salario; }

    public EstatusEmpleado getEstatus() { return estatus; }
    public void setEstatus(EstatusEmpleado estatus) { this.estatus = estatus; }

    public LocalDate getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

}
