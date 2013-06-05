package com.ninja_squad.geektic;

import java.util.List;

public interface GeekDAOInterface {

	public abstract List<Geek> findByTypeInteret(TypeInteret typeInteret);

}