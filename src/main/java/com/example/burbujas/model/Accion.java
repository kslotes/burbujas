package com.example.burbujas.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "accion")
public class Accion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accionId;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "accion")
    List<Auditoria> auditorias;

    public Accion() {

    }

    public Long getAccionId() {
        return accionId;
    }

    public void setAccionId(Long accionId) {
        this.accionId = accionId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Auditoria> getAuditorias() {
        return auditorias;
    }

    public void setAuditorias(List<Auditoria> auditorias) {
        this.auditorias = auditorias;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Accion accion = (Accion) o;
        return Objects.equals(accionId, accion.accionId) && Objects.equals(descripcion, accion.descripcion) && Objects.equals(auditorias, accion.auditorias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accionId, descripcion, auditorias);
    }
}
