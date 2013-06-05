package com.ninja_squad.geektic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * Entity implementation class for Entity: Geek
 */
@Entity
public class Geek {

	@Id
	@SequenceGenerator(name = "geek_generator", sequenceName = "GEEK_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geek_generator")
	private Long id;
	
	private String nom;
	
	private String prenom;
	
	private Long age;
	
	@OneToMany(mappedBy = "geek")
	private Set<Interet> interets = new HashSet<>(0);
	
	public Geek() {
	}
	
	public Geek(String nom, String prenom, Long age) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}
	
	public Set<Interet> getInterets() {
		return Collections.unmodifiableSet(interets);
	}
	
	public void addInteret(Interet interet) {
		interets.setGeek(this);
		interets.add(interet);
	}
}
