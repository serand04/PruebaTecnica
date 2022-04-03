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

import com.smartsoft.prueba.api.model.Factura;
import com.smartsoft.prueba.api.service.FacturaService;

@RestController
@RequestMapping("/api/factura/")
public class FacturaREST {
	
	@Autowired
	private FacturaService facturaService;
	
	@PostMapping
	private ResponseEntity<Factura> guardar(@RequestBody Factura factura) {
		Factura temporal = facturaService.create(factura);
		
		try {
			return ResponseEntity.created(new URI("/api/factura"+temporal.getNum_factura())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping
	private ResponseEntity<List<Factura>> listarFacturas() {
		return ResponseEntity.ok(facturaService.getAllFacturas());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarFacturas(@RequestBody Factura factura) {
		facturaService.delete(factura);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<Factura>> listarFacturaById(@PathVariable ("id") Long id) {
		return ResponseEntity.ok(facturaService.findById(id));
	}

}
