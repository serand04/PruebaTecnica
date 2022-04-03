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

import com.smartsoft.prueba.api.model.Cliente;
import com.smartsoft.prueba.api.service.ClienteService;

/*
 * Clase Controller de cliente
 * Aquí estan los métodos get & post para la API REST
 */

@RestController
@RequestMapping("/api/cliente/")
public class ClienteREST {
	
	//Atributo que trae la interface de Cliente
	@Autowired
	private ClienteService clienteService;
	
	//Método post en el cual se guarda el cliente
	@PostMapping
	private ResponseEntity<Cliente> guardar(@RequestBody Cliente cliente) {
		Cliente temporal = clienteService.create(cliente);
		
		try {
			return ResponseEntity.created(new URI("/api/cliente"+temporal.getId_cliente())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	//Método get para listar todos los clientes
	@GetMapping
	private ResponseEntity<List<Cliente>> listarClientes() {
		return ResponseEntity.ok(clienteService.getAllClientes());
	}
	
	//Método delete para borrar un cliente
	@DeleteMapping
	private ResponseEntity<Void> eliminarClientes(@RequestBody Cliente cliente) {
		clienteService.delete(cliente);
		return ResponseEntity.ok().build();
	}
	
	//Método get para buscar clientes por ID
	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<Cliente>> listarClientesByID(@PathVariable ("id") Long id) {
		return ResponseEntity.ok(clienteService.findById(id));
	}

}
