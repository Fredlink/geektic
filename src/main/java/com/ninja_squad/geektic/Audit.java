package com.ninja_squad.geektic;

import javax.persistence.*;

@Entity
public class Audit {

	@Id
	@SequenceGenerator(name = "audit_generator", sequenceName = "AUDIT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "audit_generator")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "idGeek", nullable = false)
	private Geek geek;
	
	private String dateVisite;
	
	private String ip;
	
	public Audit(){
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Geek getGeek() {
		return geek;
	}

	public void setGeek(Geek geek) {
		this.geek = geek;
	}

	public String getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(String dateVisite) {
		this.dateVisite = dateVisite;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
