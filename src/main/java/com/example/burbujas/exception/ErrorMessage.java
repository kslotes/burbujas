package com.example.burbujas.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private int codigo;
    private LocalDateTime fecha;
    private String mensaje;
    private String descripcion;
}