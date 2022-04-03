package com.smartsoft.prueba.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartsoft.prueba.api.model.Producto;
import com.smartsoft.prueba.api.repository.ProductoRepository;

/*
 * Clase de servicio del Producto
 * En esta clase es donde se crea, lista, borra y busca el producto
 */

@Service
public class ProductoService {
	
	//Atributo que trae la interface de Producto
	@Autowired
	private ProductoRepository productoRepository;
	
	//Método para crear un producto
	public Producto create(Producto producto) {
		return productoRepository.save(producto);
	}
	
	//Método para listar todos los productos
	public List<Producto> getAllProductos() {
		return productoRepository.findAll();
	}
	
	//Método para borrar un producto
	public void delete(Producto producto) {
		productoRepository.delete(producto);
	}
	
	//Método para buscar los productos por ID
	public Optional<Producto> findById(Long id) {
		return productoRepository.findById(id);
	}
	
}
