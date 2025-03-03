package com.example.burbujas.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productoId;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Usuario proveedor;

    @Column(name = "costo")
    private BigDecimal costo;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "stock")
    private BigDecimal stock;

    @Column(name = "porc_gan_menor")
    private BigDecimal porcGanMenor;

    @Column(name = "porc_gan_mayor")
    private BigDecimal porcGanMayor;

    public Producto() {
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
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

    public Usuario getProveedor() {
        return proveedor;
    }

    public void setProveedor(Usuario proveedor) {
        this.proveedor = proveedor;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public BigDecimal getPorcGanMenor() {
        return porcGanMenor;
    }

    public void setPorcGanMenor(BigDecimal porcGanMenor) {
        this.porcGanMenor = porcGanMenor;
    }

    public BigDecimal getPorcGanMayor() {
        return porcGanMayor;
    }

    public void setPorcGanMayor(BigDecimal porcGanMayor) {
        this.porcGanMayor = porcGanMayor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(productoId, producto.productoId) && Objects.equals(descripcion, producto.descripcion) && Objects.equals(fechaCreacion, producto.fechaCreacion) && Objects.equals(proveedor, producto.proveedor) && Objects.equals(costo, producto.costo) && Objects.equals(categoria, producto.categoria) && Objects.equals(codigoBarras, producto.codigoBarras) && Objects.equals(stock, producto.stock) && Objects.equals(porcGanMenor, producto.porcGanMenor) && Objects.equals(porcGanMayor, producto.porcGanMayor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId, descripcion, fechaCreacion, proveedor, costo, categoria, codigoBarras, stock, porcGanMenor, porcGanMayor);
    }
}
