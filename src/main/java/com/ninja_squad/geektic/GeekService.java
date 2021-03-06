package com.ninja_squad.geektic;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GeekService {
	
	@Autowired
	GeekDao geekDao;
	
	public List<Geek> listGeeks(){
		List<Geek> listSpectacles = geekDao.findAll();
		return listSpectacles;
	}
	
	public Geek getGeek(Long id){
		Geek geek = geekDao.findById(id);
		try {
			geekDao.majVisite(id);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return geek;
	}
	
	public List<Geek> find(String name) {
		List<Geek> geeks = new ArrayList<>();
		geeks = geekDao.findByNom(name);
		return geeks;
	}
	
	public List<Geek> find(TypeInteret typeInteret) {
		List<Geek> geeks = new ArrayList<>();
		geeks = geekDao.findByTypeInteret(typeInteret);
		return geeks;
	}
}
