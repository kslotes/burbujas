package com.example.burbujas.domain.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "metodo_pago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long metodoPagoId;

    @Column(name = "descripcion")
    private String descripcion;

    public MetodoPago() {

    };

    public Long getMetodoPagoId() {
        return metodoPagoId;
    }

    public void setMetodoPagoId(Long metodoPagoId) {
        this.metodoPagoId = metodoPagoId;
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
        MetodoPago that = (MetodoPago) o;
        return Objects.equals(metodoPagoId, that.metodoPagoId) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metodoPagoId, descripcion);
    }
}
