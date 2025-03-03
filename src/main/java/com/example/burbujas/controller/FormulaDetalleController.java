package com.example.burbujas.controller;

import com.example.burbujas.domain.model.FormulaDetalle;
import com.example.burbujas.exception.NotFoundException;
import com.example.burbujas.service.FormulaDetalleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/formuladetalle")
@Slf4j
@AllArgsConstructor
public class FormulaDetalleController {
    private final FormulaDetalleService formulaDetalleService;

    @GetMapping()
    public List<FormulaDetalle> findAll(){
        return formulaDetalleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormulaDetalle> findById(@PathVariable Long id) {
        return formulaDetalleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<FormulaDetalle> save(@RequestBody FormulaDetalle formulaDetalle) {
        FormulaDetalle formulaDetalleGuardado = formulaDetalleService.save(formulaDetalle);
        return ResponseEntity.status(HttpStatus.CREATED).body(formulaDetalleGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        Optional<FormulaDetalle> formulaDetalle = formulaDetalleService.findById(id);
        if (formulaDetalle.isEmpty()) {
            throw new NotFoundException("FormulaDetalle no encontrado");
        }
        formulaDetalleService.delete(id);
        return ResponseEntity.ok().build();
    }

}
