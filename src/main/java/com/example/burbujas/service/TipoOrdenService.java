package com.example.burbujas.service;

import com.example.burbujas.domain.model.TipoOrden;
import com.example.burbujas.domain.repository.TipoOrdenRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@AllArgsConstructor
public class TipoOrdenService {
    private final TipoOrdenRepository tipoOrdenRepository;

    public List<TipoOrden> findAll() {
        return tipoOrdenRepository.findAll();
    }

    public Optional<TipoOrden> findById(Long id) {
        return tipoOrdenRepository.findById(id);
    }

    public TipoOrden save(TipoOrden tipoOrden) {
        return tipoOrdenRepository.save(tipoOrden);
    }

    public void delete(Long id) {
        tipoOrdenRepository.deleteById(id);
    }

}
