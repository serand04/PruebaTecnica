package com.smartsoft.prueba.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Clase que contiene los atributos del producto
 * Estos atributos seran los mismos en la base de datos
 */
@Entity
@Table (name = "producto")
public class Producto {
	
	//Variable ID que será generada automaticamente
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_producto;
	private String nombre;
	private int precio;
	private int stock;
	//Variable que será la llave fóranea
	@OneToMany(mappedBy = "id_producto", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Detalle> detalles;
	
	//Constructor de la clase
	public Producto(int id_producto, String nombre, int precio, int stock) {
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.detalles = new HashSet<Detalle>();
	}
		
	//Getters & Setter
	public Producto() {
		this.detalles = new HashSet<Detalle>();
	}

	public int getId_producto() {
		return id_producto;
	}
	
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
}
