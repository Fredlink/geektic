package com.ninja_squad.geektic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class GeekDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Geek> findAll() {
		String jpql = "select geek from Geek geek order by geek.nom";
		return em.createQuery(jpql, Geek.class).getResultList();
	}
	
	public void persist(Geek geek) {
		em.persist(geek);
	}
	
	public Geek findById(Long id) {
		return em.find(Geek.class, id);
	}
	
	public List<Geek> findByNom(String nom) {
		String jpql = 
			"select geek from Geek geek"
			+ " where lower(geek.nom) like :nom"
			+ " order by geek.nom";
		return em.createQuery(jpql, Geek.class)
				 .setParameter("nom", "%" + nom.toLowerCase() + "%")
				 .getResultList();
	}
}
