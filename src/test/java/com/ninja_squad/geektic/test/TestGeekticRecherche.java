package com.ninja_squad.geektic.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninja_squad.geektic.Geek;
import com.ninja_squad.geektic.GeekDAOInterface;
import com.ninja_squad.geektic.GeekService;
import com.ninja_squad.geektic.TypeInteret;


public class TestGeekticRecherche {
	
	@Test
	public void testRechercheBaseVide() {
		GeekDAOInterface geekDAOInterface = mock(GeekDAOInterface.class);
		when(geekDAOInterface.findByTypeInteret((TypeInteret) anyObject()))
				.thenReturn(new ArrayList<Geek>());
		GeekService geekService = new GeekService();
		for (TypeInteret typeInteret : TypeInteret.values()) {
			List<Geek> geeks = geekService.find(typeInteret); // mocker DAO
			assertEquals(0, geeks.size());
		}
	}
}