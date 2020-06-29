package com.example.AppAgricultura_v1;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Movimentacao extends AbstractEntity{

	private String dt_entrada;
	private String dt_saida;
	public boolean status;
	
	
	@ManyToOne
	private Recurso recursos;
	
	@ManyToOne
	private Usuario usuario;
	
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Recurso getRecursos() {
		return recursos;
	}
	public void setRecursos(Recurso recursos) {
		this.recursos = recursos;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getDt_entrada() {
		return dt_entrada;
	}
	public void setDt_entrada(String dt_entrada) {
		this.dt_entrada = dt_entrada;
	}
	public String getDt_saida() {
		return dt_saida;
	}
	public void setDt_saida(String dt_saida) {
		this.dt_saida = dt_saida;
	}
	
	
}
