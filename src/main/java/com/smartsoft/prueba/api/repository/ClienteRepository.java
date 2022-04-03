package com.smartsoft.prueba.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartsoft.prueba.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
