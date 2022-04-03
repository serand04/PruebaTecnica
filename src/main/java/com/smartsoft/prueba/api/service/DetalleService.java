package com.smartsoft.prueba.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartsoft.prueba.api.model.Detalle;
import com.smartsoft.prueba.api.repository.DetalleRepository;

@Service
public class DetalleService {
	
	@Autowired
	private DetalleRepository detalleRepository;
	
	public Detalle create(Detalle detalle) {
		return detalleRepository.save(detalle);
	}
	
	public List<Detalle> getAllDetalle() {
		return detalleRepository.findAll();
	}
	
	public void delete(Detalle detalle) {
		detalleRepository.delete(detalle);
	}
	
	public Optional<Detalle> findById(Long id) {
		return detalleRepository.findById(id);
	}

}
