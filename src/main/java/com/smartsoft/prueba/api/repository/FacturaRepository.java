package com.smartsoft.prueba.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartsoft.prueba.api.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long>{

}
