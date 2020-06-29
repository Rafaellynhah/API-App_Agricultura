package com.example.AppAgricultura_v1;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Gasto extends AbstractEntity{
	

	private String mes;
	
	private float qtd_mensal;
	
	private float media_gasto;

	
	@ManyToOne
	private Tipo_Gasto tp_gasto;
	
	@ManyToOne
	private Usuario usuario;
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tipo_Gasto getTp_gasto() {
		return tp_gasto;
	}

	public void setTp_gasto(Tipo_Gasto tp_gasto) {
		this.tp_gasto = tp_gasto;
	}



	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public float getQtd_mensal() {
		return qtd_mensal;
	}

	public void setQtd_mensal(float qtd_mensal) {
		this.qtd_mensal = qtd_mensal;
	}

	public float getMedia_gasto() {
		return media_gasto;
	}

	public void setMedia_gasto(float media_gasto) {
		this.media_gasto = media_gasto;
	}


	

}
