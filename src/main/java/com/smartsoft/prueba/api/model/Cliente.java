package com.smartsoft.prueba.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Clase que contiene los atributos del cliente
 * Estos atributos seran los mismos en la base de datos
 */

@Entity
@Table (name = "cliente")
public class Cliente {
	
	//Variable ID que será generada automaticamente
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_cliente;
	private String nombre;
	private String apellido;
	private String direccion;
	private String fecha_nacimiento;
	private int telefono;
	private String email;
	// Variable que será la llave fóranea
	@OneToMany(mappedBy = "id_cliente", fetch = FetchType.LAZY)
	private Set<Factura> facturas;
	
	//Constructor de la clase
	public Cliente(int id_cliente, String nombre, String apellido, String direccion, String fecha_nacimiento, int telefono,
			String email) {
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
		this.email = email;
		this.facturas = new HashSet<Factura>();
	}
	
	public Cliente() {
		this.facturas = new HashSet<Factura>();
	}
	
	//Getters & Setters
	public int getId_cliente() {
		return id_cliente;
	}
	
	public void setId_Cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(Set<Factura> facturas) {
		this.facturas = facturas;
	}
	
}
