package com.projeto.request;

import java.util.List;

import com.projeto.dto.RegistroEnergiaDTO;

public class RegistroEnergiaRequest extends BaseRequest {
	List<RegistroEnergiaDTO> valores;

    public RegistroEnergiaRequest() { }

    public RegistroEnergiaRequest(List<RegistroEnergiaDTO> valores) {
        super();
        this.valores = valores;
    }

    public List<RegistroEnergiaDTO> getValores() {
        return valores;
    }

    public void setValores(List<RegistroEnergiaDTO> valores) {
        this.valores = valores;
    }

    @Override
    public String toString() {
        return "RegistroRequest [valores=" + valores + "]";
    }
}
