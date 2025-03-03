package com.example.burbujas.controller;

import com.example.burbujas.domain.model.Rol;
import com.example.burbujas.exception.NotFoundException;
import com.example.burbujas.service.RolService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/rol")
@Slf4j
@AllArgsConstructor
public class RolController {
    private final RolService rolService;

    @GetMapping()
    public List<Rol> findAll(){
        return rolService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> findById(@PathVariable Long id) {
        return rolService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Rol> save(@RequestBody Rol rol) {
        Rol rolGuardado = rolService.save(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(rolGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        Optional<Rol> rol = rolService.findById(id);
        if (rol.isEmpty()) {
            throw new NotFoundException("Rol no encontrado");
        }
        rolService.delete(id);
        return ResponseEntity.ok().build();
    }

}
