package com.example.burbujas.service;

import com.example.burbujas.domain.model.Accion;
import com.example.burbujas.domain.repository.AccionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@AllArgsConstructor
public class AccionService {

    private final AccionRepository accionRepository;

    public List<Accion> findAll() {
        return accionRepository.findAll();
    }

    public Optional<Accion> findById(Long id) {
        return accionRepository.findById(id);
    }

    public Accion save(Accion accion) {
        return accionRepository.save(accion);
    }

    public void delete(Long id) {
        accionRepository.deleteById(id);
    }
}
