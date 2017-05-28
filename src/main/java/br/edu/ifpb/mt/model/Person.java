package br.edu.ifpb.mt.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	private Token tokenFCM;

	public Person() {

	}

	public Person(String name, Token tokenFCM) {
		this.name = name;
		this.tokenFCM = tokenFCM;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Token getTokenFCM() {
		return tokenFCM;
	}

	public void setTokenFCM(Token tokenFCM) {
		this.tokenFCM = tokenFCM;
	}

}
