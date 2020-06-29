package com.example.AppAgricultura_v1;

import javax.persistence.Entity;

@Entity
public class Tipo_Gasto extends AbstractEntity {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
