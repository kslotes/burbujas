package com.example.burbujas.controller;

import com.example.burbujas.domain.model.Orden;
import com.example.burbujas.exception.NotFoundException;
import com.example.burbujas.service.OrdenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orden")
@Slf4j
@AllArgsConstructor
public class OrdenController {
    private final OrdenService ordenService;

    @GetMapping()
    public List<Orden> findAll(){
        return ordenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orden> findById(@PathVariable Long id) {
        return ordenService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Orden> save(@RequestBody Orden orden) {
        Orden ordenGuardado = ordenService.save(orden);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        Optional<Orden> orden = ordenService.findById(id);
        if (orden.isEmpty()) {
            throw new NotFoundException("Orden no encontrado");
        }
        ordenService.delete(id);
        return ResponseEntity.ok().build();
    }

}
