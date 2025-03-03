package com.example.burbujas.controller;

import com.example.burbujas.domain.model.MetodoPago;
import com.example.burbujas.exception.NotFoundException;
import com.example.burbujas.service.MetodoPagoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/metodopago")
@Slf4j
@AllArgsConstructor
public class MetodoPagoController {
    private final MetodoPagoService metodoPagoService;

    @GetMapping()
    public List<MetodoPago> findAll(){
        return metodoPagoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> findById(@PathVariable Long id) {
        return metodoPagoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<MetodoPago> save(@RequestBody MetodoPago metodoPago) {
        MetodoPago metodoPagoGuardado = metodoPagoService.save(metodoPago);
        return ResponseEntity.status(HttpStatus.CREATED).body(metodoPagoGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        Optional<MetodoPago> metodoPago = metodoPagoService.findById(id);
        if (metodoPago.isEmpty()) {
            throw new NotFoundException("MetodoPago no encontrado");
        }
        metodoPagoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
