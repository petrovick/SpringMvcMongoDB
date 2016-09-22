package com.projeto.business;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "registroenergia")
public class RegistroEnergia {
	@Id
	private String id;
    private String dataHora;
    private Long kws;
    
    @DBRef
    private Casa casa;
    
    @DBRef
    private Usuario user;

    public RegistroEnergia() { }
    
    public RegistroEnergia(String id, String dataHora, Long kws, Casa casa, Usuario user) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.kws = kws;
		this.casa = casa;
		this.user = user;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	@Override
	public String toString() {
		return "[dataHora=" + dataHora + ", kws=" + kws + "]";
	}
}