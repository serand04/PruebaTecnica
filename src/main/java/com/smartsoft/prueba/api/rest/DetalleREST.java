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

import com.smartsoft.prueba.api.model.Detalle;
import com.smartsoft.prueba.api.service.DetalleService;

/*
 * Clase Controller de detalle
 * Aquí estan los métodos get & post para la API REST
 */

@RestController
@RequestMapping("/api/detalle/")
public class DetalleREST {
	
	//Atributo que trae la interface de Detalle
	@Autowired
	private DetalleService detalleService;
	
	//Método post en el cual se guarda el detalle
	@PostMapping
	private ResponseEntity<Detalle> guardar(@RequestBody Detalle detalle) {
		Detalle temporal = detalleService.create(detalle);
		
		try {
			return ResponseEntity.created(new URI("/api/detalle"+temporal.getNum_detalle())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	//Método get para listar todos los detalles
	@GetMapping
	private ResponseEntity<List<Detalle>> listarDetalle() {
		return ResponseEntity.ok(detalleService.getAllDetalle());
	}
	
	//Método delete para borrar un detalle
	@DeleteMapping
	private ResponseEntity<Void> eliminarDetalle(@RequestBody Detalle detalle) {
		detalleService.delete(detalle);
		return ResponseEntity.ok().build();
	}
	
	//Método get para buscar detalles por ID
	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<Detalle>> listarDetalleById(@PathVariable ("id") Long id) {
		return ResponseEntity.ok(detalleService.findById(id));
	}

}
