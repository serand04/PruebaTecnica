package com.smartsoft.prueba.api.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartsoft.prueba.api.model.Producto;
import com.smartsoft.prueba.api.service.ProductoService;

/*
 * Clase Controller de Producto
 * Aquí estan los métodos get & post para la API REST
 */

@RestController
@RequestMapping("/api/producto/")
public class ProductoREST {
	
	//Atributo que trae la interface de Producto
	@Autowired
	private ProductoService productoService;
	
	//Método post en el cual se guarda el producto
	@PostMapping
	private ResponseEntity<Producto> guardar(@RequestBody Producto producto) {
		Producto temporal = productoService.create(producto);
		
		try {
			return ResponseEntity.created(new URI("/api/producto"+temporal.getId_producto())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	//Método get para listar todos los productos
	@GetMapping
	private ResponseEntity<List<Producto>> listarProductos() {
		return ResponseEntity.ok(productoService.getAllProductos());
	}
	
	//Método delete para borrar un producto
	@DeleteMapping
	private ResponseEntity<Void> eliminarProductos(@RequestBody Producto producto) {
		productoService.delete(producto);
		return ResponseEntity.ok().build();
	}
	
	//Método get para buscar producto por ID
	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<Producto>> listarProductosById(@PathVariable ("id") Long id) {
		return ResponseEntity.ok(productoService.findById(id));
	}

}
