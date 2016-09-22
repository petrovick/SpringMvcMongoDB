package com.projeto.dto;

import com.projeto.business.Casa;

public class RegistroEnergiaDTO
{
    private String id;
    private String dataHora;
    private Long kws;
    private String email;
    private Casa casa;

    public RegistroEnergiaDTO() { }

    public RegistroEnergiaDTO(String id, String dataHora, Long kws, String email, Casa casa) {
        this.id = id;
        this.dataHora = dataHora;
        this.kws = kws;
        this.email = email;
        this.casa = casa;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public Long getKws() {
        return kws;
    }

    public void setKws(Long kws) {
        this.kws = kws;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
