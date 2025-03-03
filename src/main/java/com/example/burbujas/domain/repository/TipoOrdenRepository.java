package com.example.burbujas.domain.repository;

import com.example.burbujas.domain.model.TipoOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoOrdenRepository extends JpaRepository<TipoOrden, Long> {
}
