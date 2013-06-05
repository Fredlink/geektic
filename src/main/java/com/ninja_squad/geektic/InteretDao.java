package com.ninja_squad.geektic;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class InteretDao {

	@PersistenceContext
	private EntityManager em;
}
