package com.example.burbujas.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_orden")
public class TipoOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipoOrdenId;
}
