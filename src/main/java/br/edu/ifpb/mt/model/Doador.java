package br.edu.ifpb.mt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String nome;

	private String tokenFCM;

	public Doador() {

	}

	public Doador(String nome, String tokenFCM) {
		this.nome = nome;
		this.tokenFCM = tokenFCM;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTokenFCM() {
		return tokenFCM;
	}

	public void setTokenFCM(String tokenFCM) {
		this.tokenFCM = tokenFCM;
	}

	@Override
	public String toString() {
		return "Doador [nome=" + nome + ", tokenFCM=" + tokenFCM + "]";
	}

}
