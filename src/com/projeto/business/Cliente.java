package com.projeto.business;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cliente")
public class Cliente
{
	private String email;
	private String usuario;
	private String senha;
	public Cliente() { }
	public Cliente(String email, String usuario, String senha) {
		super();
		this.email = email;
		this.usuario = usuario;
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
