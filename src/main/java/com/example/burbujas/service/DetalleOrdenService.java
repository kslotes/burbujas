package com.example.burbujas.service;

import com.example.burbujas.domain.model.DetalleOrden;
import com.example.burbujas.domain.repository.DetalleOrdenRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@AllArgsConstructor
public class DetalleOrdenService {
    private final DetalleOrdenRepository detalleOrdenRepository;

    public List<DetalleOrden> findAll() {
        return detalleOrdenRepository.findAll();
    }

    public Optional<DetalleOrden> findById(Long id) {
        return detalleOrdenRepository.findById(id);
    }

    public DetalleOrden save(DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }

    public void delete(Long id) {
        detalleOrdenRepository.deleteById(id);
    }

}
