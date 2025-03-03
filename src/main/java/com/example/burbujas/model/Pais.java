package com.example.burbujas.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "pais")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paisId;

    @Column(name = "descripcion")
    private String descripcion;

    public Pais() {

    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
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
        Pais pais = (Pais) o;
        return Objects.equals(paisId, pais.paisId) && Objects.equals(descripcion, pais.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paisId, descripcion);
    }
}
