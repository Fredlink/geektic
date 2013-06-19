package com.ninja_squad.geektic;

import javax.persistence.*;

@Entity
public class Audit {

	@Id
	@SequenceGenerator(name = "audit_generator", sequenceName = "AUDIT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "audit_generator")
	private Long id;
	
	private Long idGeek;
	
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

	public Long getIdGeek() {
		return idGeek;
	}

	public void setIdGeek(Long idGeek) {
		this.idGeek = idGeek;
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
