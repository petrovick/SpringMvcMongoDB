package com.spring.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginResponse extends BaseResponse
{
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
