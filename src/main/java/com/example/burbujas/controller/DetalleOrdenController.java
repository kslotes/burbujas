package com.example.burbujas.controller;

import com.example.burbujas.domain.model.DetalleOrden;
import com.example.burbujas.exception.NotFoundException;
import com.example.burbujas.service.DetalleOrdenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/detalleorden")
@Slf4j
@AllArgsConstructor
public class DetalleOrdenController {
    private final DetalleOrdenService detalleOrdenService;

    @GetMapping()
    public List<DetalleOrden> findAll(){
        return detalleOrdenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleOrden> findById(@PathVariable Long id) {
        return detalleOrdenService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<DetalleOrden> save(@RequestBody DetalleOrden detalleOrden) {
        DetalleOrden detalleOrdenGuardado = detalleOrdenService.save(detalleOrden);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleOrdenGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        Optional<DetalleOrden> detalleOrden = detalleOrdenService.findById(id);
        if (detalleOrden.isEmpty()) {
            throw new NotFoundException("DetalleOrden no encontrado");
        }
        detalleOrdenService.delete(id);
        return ResponseEntity.ok().build();
    }

}
