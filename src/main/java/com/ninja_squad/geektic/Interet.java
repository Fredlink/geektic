package com.ninja_squad.geektic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Interet {
	
	@Id
	@SequenceGenerator(name = "interet_generator", sequenceName = "INTERET_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interet_generator")
	private Long id;
	
	private String interet;
	
	@ManyToOne
	@JoinColumn(name = "id_geek", nullable = false)
	private Geek geek;

	public Interet() {
	}
	
	public Interet(TypeInteret typeInteret) {
		this.setInteret(typeInteret);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInteret() {
		return interet;
	}

	public void setInteret(TypeInteret interet) {
		this.interet = interet.toString();
	}

	public Geek getGeek() {
		return geek;
	}

	public void setGeek(Geek geek) {
		this.geek = geek;
	}
}
