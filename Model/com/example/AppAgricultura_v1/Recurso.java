package com.example.AppAgricultura_v1;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Recurso extends AbstractEntity{

	
	private String nome;
	
	private int qtd_inicial;
	
	private int qtd_final;
	
	private int produtividade_esperada;
	
	private float produtividade;
	
	private String problema;
	
	private String dt_entrada;
	private String dt_saida;
	
	

	@ManyToOne
	private Tipo_Recurso tp_recurso;
	

	public Tipo_Recurso getTp_recurso() {
		return tp_recurso;
	}

	public void setTp_recurso(Tipo_Recurso tp_recurso) {
		this.tp_recurso = tp_recurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getQtd_final() {
		return qtd_final;
	}

	public void setQtd_final(int qtd_final) {
		this.qtd_final = qtd_final;
	}

	public int getProdutividade_esperada() {
		return produtividade_esperada;
	}

	public void setProdutividade_esperada(int produtividade_esperada) {
		this.produtividade_esperada = produtividade_esperada;
	}

	public float getProdutividade() {
		return produtividade;
	}

	public void setProdutividade(float produtividade) {
		this.produtividade = produtividade;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public int getQtd_inicial() {
		return qtd_inicial;
	}

	public void setQtd_inicial(int qtd_inicial) {
		this.qtd_inicial = qtd_inicial;
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
