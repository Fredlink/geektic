package com.ninja_squad.geektic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class GeekDao implements GeekDAOInterface {
	
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
	/* (non-Javadoc)
	 * @see com.ninja_squad.geektic.GeekDAOInterface#findByTypeInteret(com.ninja_squad.geektic.TypeInteret)
	 */
	@Override
	public List<Geek> findByTypeInteret(TypeInteret typeInteret) {
		String jpql = 			
				"select geek from Geek geek " +
				"LEFT JOIN geek.interets interet where interet.interet = :TypeInteret";
			return em.createQuery(jpql, Geek.class)
					 .setParameter("TypeInteret", typeInteret)
					 .getResultList();
	}
}
