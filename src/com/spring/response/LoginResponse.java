package com.spring.response;

import javax.xml.bind.annotation.XmlRootElement;

import com.projeto.business.Usuario;

@XmlRootElement
public class LoginResponse extends BaseResponse
{
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
