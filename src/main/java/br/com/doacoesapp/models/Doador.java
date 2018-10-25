package br.com.doacoesapp.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Doador{
	
	@Id
	private String rg;
	
	private String nomeDoador;
	
	@ManyToOne
	private Doacao doacao;

	
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNomeDoador() {
		return nomeDoador;
	}

	public void setNomeDoador(String nomeDoador) {
		this.nomeDoador = nomeDoador;
	}

	public Doacao getDoacao() {
		return doacao;
	}

	public void setDoacao(Doacao doacao) {
		this.doacao = doacao;
	}

	
}