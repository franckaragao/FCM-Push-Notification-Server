package br.edu.ifpb.mt.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Entity
public class Doador {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String nome;

	@OneToOne(cascade = CascadeType.ALL)
	private Token tokenFCM;

	public Doador() {

	}

	public Doador(String nome, Token tokenFCM) {
		this.nome = nome;
		this.tokenFCM = tokenFCM;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Token getTokenFCM() {
		return tokenFCM;
	}

	public void setTokenFCM(Token tokenFCM) {
		this.tokenFCM = tokenFCM;
	}

	@Override
	public String toString() {
		return "Doador [id=" + id + ", nome=" + nome + ", tokenFCM=" + tokenFCM + "]";
	}

}
