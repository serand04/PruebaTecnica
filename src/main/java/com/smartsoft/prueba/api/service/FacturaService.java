package com.smartsoft.prueba.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartsoft.prueba.api.model.Factura;
import com.smartsoft.prueba.api.repository.FacturaRepository;

@Service
public class FacturaService {
	
	@Autowired
	private FacturaRepository facturaRepository;
	
	public Factura create(Factura factura) {
		return facturaRepository.save(factura);
	}
	
	public List<Factura> getAllFacturas() {
		return facturaRepository.findAll();
	}
	
	public Optional<Factura> findById(Long id) {
		return facturaRepository.findById(id);
	}
	
	public void delete(Factura factura) {
		facturaRepository.delete(factura);
	}
	

}
