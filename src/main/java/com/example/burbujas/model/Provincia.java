package com.example.burbujas.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "provincia")
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long provinciaId;

    @Column(name = "descripcion")
    private String descripcion;

    public Provincia() {
    }

    public Long getProvinciaId() {
        return provinciaId;
    }

    public void setProvinciaId(Long provinciaId) {
        this.provinciaId = provinciaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Provincia provincia = (Provincia) o;
        return Objects.equals(provinciaId, provincia.provinciaId) && Objects.equals(descripcion, provincia.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(provinciaId, descripcion);
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
