package com.example.burbujas.controller;

import com.example.burbujas.domain.model.Auditoria;
import com.example.burbujas.exception.NotFoundException;
import com.example.burbujas.service.AuditoriaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auditoria")
@Slf4j
@AllArgsConstructor
public class AuditoriaController {
    private final AuditoriaService auditoriaService;

    @GetMapping()
    public List<Auditoria> findAll(){
        return auditoriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auditoria> findById(@PathVariable Long id) {
        return auditoriaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Auditoria> save(@RequestBody Auditoria auditoria) {
        Auditoria auditoriaGuardado = auditoriaService.save(auditoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(auditoriaGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        Optional<Auditoria> auditoria = auditoriaService.findById(id);
        if (auditoria.isEmpty()) {
            throw new NotFoundException("Auditoria no encontrada");
        }
        auditoriaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
