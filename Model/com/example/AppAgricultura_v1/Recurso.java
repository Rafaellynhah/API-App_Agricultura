package com.example.AppAgricultura_v1;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Recurso extends AbstractEntity{

	private String nome;
	
	private int qtd_incial;
	
	private int qtd_final;
	
	private int produtividade_esperada;
	
	private float produtividade;
	
	private String problema;
	
	
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

	public int getQtd_incial() {
		return qtd_incial;
	}

	public void setQtd_incial(int qtd_incial) {
		this.qtd_incial = qtd_incial;
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

	

	
}
