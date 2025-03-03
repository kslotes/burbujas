package com.example.burbujas.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolId;

    @Column(name = "descripcion")
    private String descripcion;

    public Rol() {
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rol rol = (Rol) o;
        return Objects.equals(rolId, rol.rolId) && Objects.equals(descripcion, rol.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolId, descripcion);
    }
}
