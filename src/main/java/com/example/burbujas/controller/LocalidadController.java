package com.example.burbujas.controller;

import com.example.burbujas.domain.model.Localidad;
import com.example.burbujas.exception.NotFoundException;
import com.example.burbujas.service.LocalidadService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/localidad")
@Slf4j
@AllArgsConstructor
public class LocalidadController {
    private final LocalidadService localidadService;

    @GetMapping()
    public List<Localidad> findAll(){
        return localidadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Localidad> findById(@PathVariable Long id) {
        return localidadService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Localidad> save(@RequestBody Localidad localidad) {
        Localidad localidadGuardado = localidadService.save(localidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(localidadGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        Optional<Localidad> localidad = localidadService.findById(id);
        if (localidad.isEmpty()) {
            throw new NotFoundException("Localidad no encontrado");
        }
        localidadService.delete(id);
        return ResponseEntity.ok().build();
    }

}
