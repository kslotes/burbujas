package com.example.burbujas.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "auditoria")
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditoriaId;

    @ManyToOne
    @JoinColumn(name = "accion_id")
    private Accion accion;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @ManyToOne()
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "observaciones")
    private String observaciones;

    public Auditoria() {
    }

    public Long getAuditoriaId() {
        return auditoriaId;
    }

    public void setAuditoriaId(Long auditoriaId) {
        this.auditoriaId = auditoriaId;
    }

    public Accion getAccion() {
        return accion;
    }

    public void setAccion(Accion accion) {
        this.accion = accion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Auditoria auditoria = (Auditoria) o;
        return Objects.equals(auditoriaId, auditoria.auditoriaId) && Objects.equals(accion, auditoria.accion) && Objects.equals(fecha, auditoria.fecha) && Objects.equals(usuario, auditoria.usuario) && Objects.equals(observaciones, auditoria.observaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(auditoriaId, accion, fecha, usuario, observaciones);
    }
}
