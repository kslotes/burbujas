package com.example.burbujas.controller;

import com.example.burbujas.domain.model.Provincia;
import com.example.burbujas.exception.NotFoundException;
import com.example.burbujas.service.ProvinciaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/provincia")
@Slf4j
@AllArgsConstructor
public class ProvinciaController {
    private final ProvinciaService provinciaService;

    @GetMapping()
    public List<Provincia> findAll(){
        return provinciaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Provincia> findById(@PathVariable Long id) {
        return provinciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Provincia> save(@RequestBody Provincia provincia) {
        Provincia provinciaGuardado = provinciaService.save(provincia);
        return ResponseEntity.status(HttpStatus.CREATED).body(provinciaGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        Optional<Provincia> provincia = provinciaService.findById(id);
        if (provincia.isEmpty()) {
            throw new NotFoundException("Provincia no encontrado");
        }
        provinciaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
