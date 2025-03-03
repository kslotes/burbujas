package com.example.burbujas.repository;

import com.example.burbujas.model.Accion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccionRepository extends JpaRepository<Accion, Long> {

}
