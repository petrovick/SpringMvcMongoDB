package com.projeto.dto;
public class RegistroEnergiaDTO
{
    private String dataHora;
    private Long kws;
    private String email;

    public RegistroEnergiaDTO() { }

    public RegistroEnergiaDTO(String dataHora, Long kws, String email) {
        this.dataHora = dataHora;
        this.kws = kws;
        this.email = email;
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
}
