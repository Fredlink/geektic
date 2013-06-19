package com.ninja_squad.geektic;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.joda.time.DateTime;
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
	
	public void merge(Geek geek) {
		em.merge(geek);
	}
	
	public Geek findById(Long id) {
		return em.find(Geek.class, id);
	}
	
	public void majVisite(Long id) throws UnknownHostException {
		Geek geekId = em.find(Geek.class, id);
		geekId.setCptVisite(geekId.getCptVisite()+1);
		merge(geekId);
        DateTime dt = DateTime.now();
		Audit aud = new Audit();
		aud.setDateVisite(dt.getDayOfMonth()+"/"+dt.getMonthOfYear()+"/"+dt.getYear()+" "+dt.getHourOfDay()+":"+dt.getMinuteOfHour());
		aud.setIdGeek(id);
		aud.setIp(InetAddress.getLocalHost().getHostAddress());
		em.persist(aud);
	}
	
	public List<Geek> findByNom(String nom) {
		String jpql = 
			"select geek from Geek geek"
			+ " where lower(geek.nom) like :nom"
			+ " or lower(geek.prenom) like :nom"
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
					 .setParameter("TypeInteret", typeInteret.toString())
					 .getResultList();
	}
}
