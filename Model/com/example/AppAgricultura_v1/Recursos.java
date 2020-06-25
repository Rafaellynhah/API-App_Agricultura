package com.example.AppAgricultura_v1;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Recursos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;


	private String nome;


	private String tipo_recurso;


	private float qtd;
	
	private String tipo_plantacao;
	
	private String tipo_animal;

	//private Date dt_entrada;
	
	public Recursos() {

	}

	public Recursos(Integer codigo, String nome, String tipo_recurso, float qtd, String tipo_plantacao,
			String tipo_animal) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.tipo_recurso = tipo_recurso;
		this.qtd = qtd;
		this.tipo_plantacao = tipo_plantacao;
		this.tipo_animal = tipo_animal;
	}

	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo_recurso() {
		return tipo_recurso;
	}

	public void setTipo_recurso(String tipo_recurso) {
		this.tipo_recurso = tipo_recurso;
	}

	public float getQtd() {
		return qtd;
	}

	public void setQtd(float qtd) {
		this.qtd = qtd;
	}

	public String getTipo_plantacao() {
		return tipo_plantacao;
	}

	public void setTipo_plantacao(String tipo_plantacao) {
		this.tipo_plantacao = tipo_plantacao;
	}

	public String getTipo_animal() {
		return tipo_animal;
	}

	public void setTipo_animal(String tipo_animal) {
		this.tipo_animal = tipo_animal;
	}

	//@CreatedDate
	//@Temporal(TemporalType.TIMESTAMP)
	//public Date getdt_entrada() {
		//return dt_entrada;
	//}
	
//	public void setdt_entrada(Date dt_entrada) {
	////	this.dt_entrada = dt_entrada;
	//}
}
