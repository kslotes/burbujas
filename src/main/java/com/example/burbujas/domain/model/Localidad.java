package com.example.burbujas.domain.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "localidad")
public class Localidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long localidadId;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "codigo_postal")
    private String codigoPostal;

    public Localidad() {

    }

    public Long getLocalidadId() {
        return localidadId;
    }

    public void setLocalidadId(Long localidadId) {
        this.localidadId = localidadId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Localidad localidad = (Localidad) o;
        return Objects.equals(localidadId, localidad.localidadId) && Objects.equals(descripcion, localidad.descripcion) && Objects.equals(codigoPostal, localidad.codigoPostal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localidadId, descripcion, codigoPostal);
    }
}

