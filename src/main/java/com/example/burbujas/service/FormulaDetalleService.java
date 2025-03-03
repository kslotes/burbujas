package com.example.burbujas.service;

import com.example.burbujas.domain.model.FormulaDetalle;
import com.example.burbujas.domain.repository.FormulaDetalleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@AllArgsConstructor
public class FormulaDetalleService {
    private final FormulaDetalleRepository FormulaDetalleRepository;

    public List<FormulaDetalle> findAll() {
        return FormulaDetalleRepository.findAll();
    }

    public Optional<FormulaDetalle> findById(Long id) {
        return FormulaDetalleRepository.findById(id);
    }

    public FormulaDetalle save(FormulaDetalle FormulaDetalle) {
        return FormulaDetalleRepository.save(FormulaDetalle);
    }

    public void delete(Long id) {
        FormulaDetalleRepository.deleteById(id);
    }

}
