package com.example.burbujas.service;

import com.example.burbujas.domain.model.Provincia;
import com.example.burbujas.domain.repository.ProvinciaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@AllArgsConstructor
public class ProvinciaService {
    private final ProvinciaRepository provinciaRepository;

    public List<Provincia> findAll() {
        return provinciaRepository.findAll();
    }

    public Optional<Provincia> findById(Long id) {
        return provinciaRepository.findById(id);
    }

    public Provincia save(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    public void delete(Long id) {
        provinciaRepository.deleteById(id);
    }

}
