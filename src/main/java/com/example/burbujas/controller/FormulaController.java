package com.example.burbujas.controller;

import com.example.burbujas.domain.model.Formula;
import com.example.burbujas.exception.NotFoundException;
import com.example.burbujas.service.FormulaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/formula")
@Slf4j
@AllArgsConstructor
public class FormulaController {
    private final FormulaService formulaService;

    @GetMapping()
    public List<Formula> findAll(){
        return formulaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formula> findById(@PathVariable Long id) {
        return formulaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Formula> save(@RequestBody Formula formula) {
        Formula formulaGuardado = formulaService.save(formula);
        return ResponseEntity.status(HttpStatus.CREATED).body(formulaGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        Optional<Formula> formula = formulaService.findById(id);
        if (formula.isEmpty()) {
            throw new NotFoundException("Formula no encontrado");
        }
        formulaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
