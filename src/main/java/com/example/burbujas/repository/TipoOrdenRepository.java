package com.example.burbujas.repository;

import com.example.burbujas.model.TipoOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoOrdenRepository extends JpaRepository<TipoOrden, Long> {
}
