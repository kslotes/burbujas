package com.example.burbujas.domain.repository;

import com.example.burbujas.domain.model.FormulaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormulaDetalleRepository extends JpaRepository<FormulaDetalle, Long> {
}
