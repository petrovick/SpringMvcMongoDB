package com.projeto.request;

import javax.xml.bind.annotation.XmlRootElement;

import com.projeto.business.Usuario;

@XmlRootElement
public class UsuarioRequest 
{
	private Usuario usuario;

	public UsuarioRequest(){}
	
	public UsuarioRequest(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
