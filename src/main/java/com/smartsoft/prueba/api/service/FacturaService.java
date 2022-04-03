package com.smartsoft.prueba.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartsoft.prueba.api.model.Factura;
import com.smartsoft.prueba.api.repository.FacturaRepository;

/*
 * Clase de servicio del Factura
 * En esta clase es donde se crea, lista, borra y busca el factura
 */

@Service
public class FacturaService {
	
	//Atributo que trae la interface de Factura
	@Autowired
	private FacturaRepository facturaRepository;
	
	//Método para crear una factura
	public Factura create(Factura factura) {
		return facturaRepository.save(factura);
	}
	
	//Método para listar todas las facturas
	public List<Factura> getAllFacturas() {
		return facturaRepository.findAll();
	}
	
	//Método para borrar una factura
	public Optional<Factura> findById(Long id) {
		return facturaRepository.findById(id);
	}
	
	//Método para buscar las facturas por ID
	public void delete(Factura factura) {
		facturaRepository.delete(factura);
	}
	

}
