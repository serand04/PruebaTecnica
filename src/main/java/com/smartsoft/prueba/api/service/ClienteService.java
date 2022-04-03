package com.smartsoft.prueba.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartsoft.prueba.api.model.Cliente;
import com.smartsoft.prueba.api.repository.ClienteRepository;

/*
 * Clase de servicio del cliente
 * En esta clase es donde se crea, lista, borra y busca el cliente
 */

@Service
public class ClienteService {
	
	//Atributo que trae la interface de Cliente
	@Autowired
	private ClienteRepository clienteRepository;
	
	//Método para crear un cliente
	public Cliente create(Cliente cliente) {
		return clienteRepository.save(cliente); 
	}
	
	//Método para listar todos los clientes
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}
	
	//Método para borrar un cliente
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
	//Método para buscar los clientes por ID
	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id); 
	}

}
