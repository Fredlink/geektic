package com.ninja_squad.geektic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ServiceRecherche {

	public List<Geek> find(TypeInteret typeInteret) {
		return new ArrayList<>();
	}

}
