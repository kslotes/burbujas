package com.example.burbujas.service;

import com.example.burbujas.domain.model.Orden;
import com.example.burbujas.domain.repository.OrdenRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@AllArgsConstructor
public class OrdenService {
    private final OrdenRepository ordenRepository;

    public List<Orden> findAll() {
        return ordenRepository.findAll();
    }

    public Optional<Orden> findById(Long id) {
        return ordenRepository.findById(id);
    }

    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }

    public void delete(Long id) {
        ordenRepository.deleteById(id);
    }

}
