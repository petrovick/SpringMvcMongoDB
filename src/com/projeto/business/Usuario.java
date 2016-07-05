package com.projeto.business;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario")
public class Usuario {
	private String email;

	private String password;
	
	private String token;
	
	private List<Casa> casas;
	
	public Usuario() { }

	public Usuario(String email, String password, String token, List<Casa> casas) {
		super();
		this.email = email;
		this.password = password;
		this.token = token;
		this.casas = casas;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<Casa> getCasas() {
		return casas;
	}

	public void setCasas(List<Casa> casas) {
		this.casas = casas;
	}


}