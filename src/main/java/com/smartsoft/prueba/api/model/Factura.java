package com.smartsoft.prueba.api.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "factura")
public class Factura {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int num_factura;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cliente id_cliente;
	
	private String fecha;
	
	public Factura(int num_factura, Cliente id_cliente, String fecha) {
		this.num_factura = num_factura;
		this.id_cliente = id_cliente;
		this.fecha = fecha;
	}
	
	public int getNum_factura() {
		return num_factura;
	}
	
	public void setNum_factura(int num_factura) {
		this.num_factura = num_factura;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public Long getCliente_id( ) {
		return (long) id_cliente.getId_cliente();
	}
	
	public String getClienteNombre() {
		return id_cliente.getNombre() + " " + id_cliente.getApellido();
	}
	
	@JsonIgnore
	public Cliente getCliente() {
		return id_cliente;
	}
	
	@JsonIgnore
	public void setCliente(Cliente id_cliente) {
		this.id_cliente = id_cliente;
	}

}
