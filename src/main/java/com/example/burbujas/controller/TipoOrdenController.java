package com.example.burbujas.controller;

import com.example.burbujas.domain.model.TipoOrden;
import com.example.burbujas.exception.NotFoundException;
import com.example.burbujas.service.TipoOrdenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tipoorden")
@Slf4j
@AllArgsConstructor
public class TipoOrdenController {
    private final TipoOrdenService tipoOrdenService;

    @GetMapping()
    public List<TipoOrden> findAll(){
        return tipoOrdenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoOrden> findById(@PathVariable Long id) {
        return tipoOrdenService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<TipoOrden> save(@RequestBody TipoOrden tipoOrden) {
        TipoOrden tipoOrdenGuardado = tipoOrdenService.save(tipoOrden);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoOrdenGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        Optional<TipoOrden> tipoOrden = tipoOrdenService.findById(id);
        if (tipoOrden.isEmpty()) {
            throw new NotFoundException("TipoOrden no encontrado");
        }
        tipoOrdenService.delete(id);
        return ResponseEntity.ok().build();
    }

}
