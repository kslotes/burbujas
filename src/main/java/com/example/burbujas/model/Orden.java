package com.example.burbujas.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "orden")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordenId;

    @ManyToOne()
    @JoinColumn(name = "usuario_id")
    private Usuario vendedor;

    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @ManyToOne()
    @JoinColumn(name = "tipo_orden_id")
    private TipoOrden tipoOrden;

    @ManyToOne()
    @JoinColumn(name = "metodo_pago_id")
    private MetodoPago metodoPago;

    @Column(name = "fecha_creacion")
    LocalDateTime fechaCreacion;

    @Column(name = "monto_costo")
    private BigDecimal montoCosto;

    @Column(name = "monto_venta")
    private BigDecimal montoVenta;

    @ManyToOne()
    @JoinColumn(name = "factura_id")
    private Factura factura;

    public Orden() {
    }

    public Long getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(Long ordenId) {
        this.ordenId = ordenId;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public TipoOrden getTipoOrden() {
        return tipoOrden;
    }

    public void setTipoOrden(TipoOrden tipoOrden) {
        this.tipoOrden = tipoOrden;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public BigDecimal getMontoCosto() {
        return montoCosto;
    }

    public void setMontoCosto(BigDecimal montoCosto) {
        this.montoCosto = montoCosto;
    }

    public BigDecimal getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(BigDecimal montoVenta) {
        this.montoVenta = montoVenta;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Orden orden = (Orden) o;
        return Objects.equals(ordenId, orden.ordenId) && Objects.equals(vendedor, orden.vendedor) && Objects.equals(cliente, orden.cliente) && Objects.equals(tipoOrden, orden.tipoOrden) && Objects.equals(metodoPago, orden.metodoPago) && Objects.equals(fechaCreacion, orden.fechaCreacion) && Objects.equals(montoCosto, orden.montoCosto) && Objects.equals(montoVenta, orden.montoVenta) && Objects.equals(factura, orden.factura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordenId, vendedor, cliente, tipoOrden, metodoPago, fechaCreacion, montoCosto, montoVenta, factura);
    }
}
