package com.smartsoft.prueba.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartsoft.prueba.api.model.Producto;
import com.smartsoft.prueba.api.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	public Producto create(Producto producto) {
		return productoRepository.save(producto);
	}
	
	public List<Producto> getAllProductos() {
		return productoRepository.findAll();
	}
	
	public void delete(Producto producto) {
		productoRepository.delete(producto);
	}
	
	public Optional<Producto> findById(Long id) {
		return productoRepository.findById(id);
	}
	
}
