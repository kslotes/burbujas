package com.example.burbujas.service;

import com.example.burbujas.domain.model.Auditoria;
import com.example.burbujas.domain.repository.AuditoriaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@AllArgsConstructor
public class AuditoriaService {
    private final AuditoriaRepository auditoriaRepository;

    public List<Auditoria> findAll() {
        return auditoriaRepository.findAll();
    }

    public Optional<Auditoria> findById(Long id) {
        return auditoriaRepository.findById(id);
    }

    public Auditoria save(Auditoria auditoria) {
        return auditoriaRepository.save(auditoria);
    }

    public void delete(Long id) {
        auditoriaRepository.deleteById(id);
    }

}
