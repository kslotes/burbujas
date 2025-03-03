package com.example.burbujas.controller;

import com.example.burbujas.domain.model.Factura;
import com.example.burbujas.exception.NotFoundException;
import com.example.burbujas.service.FacturaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/factura")
@Slf4j
@AllArgsConstructor
public class FacturaController {
    private final FacturaService facturaService;

    @GetMapping()
    public List<Factura> findAll(){
        return facturaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> findById(@PathVariable Long id) {
        return facturaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Factura> save(@RequestBody Factura factura) {
        Factura facturaGuardado = facturaService.save(factura);
        return ResponseEntity.status(HttpStatus.CREATED).body(facturaGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        Optional<Factura> factura = facturaService.findById(id);
        if (factura.isEmpty()) {
            throw new NotFoundException("Factura no encontrado");
        }
        facturaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
