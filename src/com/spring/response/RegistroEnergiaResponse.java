package com.spring.response;

import java.util.List;

import com.projeto.dto.RegistroEnergiaDTO;

public class RegistroEnergiaResponse extends BaseResponse {
	List<RegistroEnergiaDTO> registros;

	public RegistroEnergiaResponse() { }

	public RegistroEnergiaResponse(List<RegistroEnergiaDTO> registros) {
		super();
		this.registros = registros;
	}

	public List<RegistroEnergiaDTO> getRegistros() {
		return registros;
	}

	public void setRegistros(List<RegistroEnergiaDTO> registros) {
		this.registros = registros;
	}

}
