package com.example.burbujas.controller;

import com.example.burbujas.domain.model.Pais;
import com.example.burbujas.exception.NotFoundException;
import com.example.burbujas.service.PaisService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pais")
@Slf4j
@AllArgsConstructor
public class PaisController {
    private final PaisService paisService;

    @GetMapping()
    public List<Pais> findAll(){
        return paisService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> findById(@PathVariable Long id) {
        return paisService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Pais> save(@RequestBody Pais pais) {
        Pais paisGuardado = paisService.save(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body(paisGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        Optional<Pais> pais = paisService.findById(id);
        if (pais.isEmpty()) {
            throw new NotFoundException("Pais no encontrado");
        }
        paisService.delete(id);
        return ResponseEntity.ok().build();
    }

}
