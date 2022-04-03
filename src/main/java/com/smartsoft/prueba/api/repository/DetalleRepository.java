package com.smartsoft.prueba.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartsoft.prueba.api.model.Detalle;

//Interface que trae la clase Detalle y un variable Long
public interface DetalleRepository extends JpaRepository<Detalle, Long>{

}
