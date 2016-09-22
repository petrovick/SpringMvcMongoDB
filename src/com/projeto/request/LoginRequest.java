package com.projeto.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.projeto.business.Usuario;

@XmlRootElement
public class LoginRequest  implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4690653598842264524L;
	private Usuario usuario;

	public LoginRequest(){}
	
	public LoginRequest(Usuario usuario) {
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
