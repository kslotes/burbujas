package com.example.burbujas.controller;

import com.example.burbujas.domain.model.Accion;
import com.example.burbujas.exception.NotFoundException;
import com.example.burbujas.service.AccionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/accion")
@Slf4j
@AllArgsConstructor
public class AccionController {

    private final AccionService accionService;
    @GetMapping()
    public List<Accion> findAll(){
        return accionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accion> findById(@PathVariable Long id) {
        return accionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Accion> save(@RequestBody Accion accion) {
        Accion accionGuardado = accionService.save(accion);
        return ResponseEntity.status(HttpStatus.CREATED).body(accionGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        Optional<Accion> accion = accionService.findById(id);
        if (accion.isEmpty()) {
            throw new NotFoundException("Accion no encontrada");
        }
        accionService.delete(id);
        return ResponseEntity.ok().build();
    }

}
