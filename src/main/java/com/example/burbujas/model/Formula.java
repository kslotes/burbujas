package com.example.burbujas.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "formula")
public class Formula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formulaId;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "costo_total")
    private BigDecimal costoTotal;

    @Column(name = "cantidad")
    private Integer cantidad;

    public Formula() {
    }

    public Long getFormulaId() {
        return formulaId;
    }

    public void setFormulaId(Long formulaId) {
        this.formulaId = formulaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public BigDecimal getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(BigDecimal costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Formula formula = (Formula) o;
        return Objects.equals(formulaId, formula.formulaId) && Objects.equals(descripcion, formula.descripcion) && Objects.equals(fechaCreacion, formula.fechaCreacion) && Objects.equals(fechaModificacion, formula.fechaModificacion) && Objects.equals(costoTotal, formula.costoTotal) && Objects.equals(cantidad, formula.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formulaId, descripcion, fechaCreacion, fechaModificacion, costoTotal, cantidad);
    }
}
