package com.smartsoft.prueba.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartsoft.prueba.api.model.Detalle;
import com.smartsoft.prueba.api.repository.DetalleRepository;

/*
 * Clase de servicio del detalle
 * En esta clase es donde se crea, lista, borra y busca el detalle
 */

@Service
public class DetalleService {
	
	//Atributo que trae la interface de Cliente
	@Autowired
	private DetalleRepository detalleRepository;
	
	//Método para crear un detalle
	public Detalle create(Detalle detalle) {
		return detalleRepository.save(detalle);
	}
	
	//Método para listar todos los detalles
	public List<Detalle> getAllDetalle() {
		return detalleRepository.findAll();
	}
	
	//Método para borrar un detalle
	public void delete(Detalle detalle) {
		detalleRepository.delete(detalle);
	}
	
	//Método para buscar los detalles por ID
	public Optional<Detalle> findById(Long id) {
		return detalleRepository.findById(id);
	}

}
