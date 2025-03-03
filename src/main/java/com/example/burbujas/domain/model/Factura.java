package com.example.burbujas.domain.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facturaId;

    @Column(name = "datos_facturacion")
    private String datosFacturacion;

    @Column(name = "condicion_iva")
    private String condicionIva;

    public Factura() {
    }

    public Long getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Long facturaId) {
        this.facturaId = facturaId;
    }

    public String getDatosFacturacion() {
        return datosFacturacion;
    }

    public void setDatosFacturacion(String datosFacturacion) {
        this.datosFacturacion = datosFacturacion;
    }

    public String getCondicionIva() {
        return condicionIva;
    }

    public void setCondicionIva(String condicionIva) {
        this.condicionIva = condicionIva;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return Objects.equals(facturaId, factura.facturaId) && Objects.equals(datosFacturacion, factura.datosFacturacion) && Objects.equals(condicionIva, factura.condicionIva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facturaId, datosFacturacion, condicionIva);
    }
}
