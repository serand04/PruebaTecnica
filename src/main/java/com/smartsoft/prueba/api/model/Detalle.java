package com.smartsoft.prueba.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "detalle")
public class Detalle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int num_detalle;
	private int id_factura;
	@ManyToOne
	@JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
	private Producto id_producto;
	private int cantidad;
	private int precio;
	
	
	
	public Detalle(int num_detalle, int id_factura, Producto id_producto, int cantidad, int precio) {
		this.num_detalle = num_detalle;
		this.id_factura = id_factura;
		this.id_producto = id_producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getNum_detalle() {
		return num_detalle;
	}
	
	public void setNum_detalle(int num_detalle) {
		this.num_detalle = num_detalle;
	}
	
	public int getId_factura() {
		return id_factura;
	}
	
	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}
	
	public Producto getId_producto() {
		return id_producto;
	}
	
	public void setId_producto(Producto id_producto) {
		this.id_producto = id_producto;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
