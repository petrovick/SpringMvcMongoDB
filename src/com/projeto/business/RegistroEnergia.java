package com.projeto.business;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "registroenergia")
public class RegistroEnergia {
	@Id
	private String id;
	private Float valor;
	private Cliente cliente;
	
	public RegistroEnergia(){}
	
	public RegistroEnergia(String id, Float valor, Cliente cliente) {
		super();
		this.id = id;
		this.valor = valor;
		this.cliente = cliente;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
