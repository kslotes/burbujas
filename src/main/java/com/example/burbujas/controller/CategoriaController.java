package com.example.burbujas.controller;

import com.example.burbujas.domain.model.Categoria;
import com.example.burbujas.exception.NotFoundException;
import com.example.burbujas.service.CategoriaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categoria")
@Slf4j
@AllArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;

    @GetMapping()
    public List<Categoria> findAll(){
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        return categoriaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
        Categoria categoriaGuardado = categoriaService.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        Optional<Categoria> categoria = categoriaService.findById(id);
        if (categoria.isEmpty()) {
            throw new NotFoundException("Categoria no encontrado");
        }
        categoriaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
