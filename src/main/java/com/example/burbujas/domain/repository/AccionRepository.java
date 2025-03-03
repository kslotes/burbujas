package com.example.burbujas.domain.repository;

import com.example.burbujas.domain.model.Accion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccionRepository extends JpaRepository<Accion, Long> {

}
