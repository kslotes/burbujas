package com.example.burbujas.service;

import com.example.burbujas.domain.model.Localidad;
import com.example.burbujas.domain.repository.LocalidadRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@AllArgsConstructor
public class LocalidadService {
    private final LocalidadRepository localidadRepository;

    public List<Localidad> findAll() {
        return localidadRepository.findAll();
    }

    public Optional<Localidad> findById(Long id) {
        return localidadRepository.findById(id);
    }

    public Localidad save(Localidad localidad) {
        return localidadRepository.save(localidad);
    }

    public void delete(Long id) {
        localidadRepository.deleteById(id);
    }

}
