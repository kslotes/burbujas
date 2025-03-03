package com.example.burbujas.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "formula_detalle")
public class FormulaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formulaDetalleId;

    @Column(name = "cantidad_producto")
    private Integer cantidadProducto;

    @ManyToOne()
    @JoinColumn(name = "formula_id")
    private Formula formula;

    @ManyToOne()
    @JoinColumn(name = "producto_id")
    private Producto producto;

}
