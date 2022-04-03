package com.smartsoft.prueba.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartsoft.prueba.api.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
