package com.example.burbujas.repository;

import com.example.burbujas.model.Formula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormulaRepository extends JpaRepository<Formula, Long> {
}
