package com.example.burbujas.service;

import com.example.burbujas.domain.model.Formula;
import com.example.burbujas.domain.repository.FormulaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@AllArgsConstructor
public class FormulaService {
    private final FormulaRepository formulaRepository;

    public List<Formula> findAll() {
        return formulaRepository.findAll();
    }

    public Optional<Formula> findById(Long id) {
        return formulaRepository.findById(id);
    }

    public Formula save(Formula formula) {
        return formulaRepository.save(formula);
    }

    public void delete(Long id) {
        formulaRepository.deleteById(id);
    }

}
