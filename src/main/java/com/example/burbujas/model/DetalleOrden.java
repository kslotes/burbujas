package com.example.burbujas.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "detalle_orden")
public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detalleOrdenId;

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne()
    @JoinColumn(name = "orden_id")
    private Orden orden;

    @ManyToOne()
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public DetalleOrden() {
    }

    public DetalleOrden(Integer cantidad, Orden orden, Producto producto) {}

    public Long getDetalleOrdenId() {
        return detalleOrdenId;
    }

    public void setDetalleOrdenId(Long detalleOrdenId) {
        this.detalleOrdenId = detalleOrdenId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DetalleOrden that = (DetalleOrden) o;
        return Objects.equals(detalleOrdenId, that.detalleOrdenId) && Objects.equals(cantidad, that.cantidad) && Objects.equals(orden, that.orden) && Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detalleOrdenId, cantidad, orden, producto);
    }
}
