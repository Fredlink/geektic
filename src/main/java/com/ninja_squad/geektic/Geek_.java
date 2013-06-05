package com.ninja_squad.geektic;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-01-04T16:54:52.471+0100")
@StaticMetamodel(Geek.class)
public class Geek_ {
	public static volatile SingularAttribute<Geek, Long> id;
	public static volatile SingularAttribute<Geek, String> nom;
	public static volatile SingularAttribute<Geek, String> prenom;
	public static volatile SingularAttribute<Geek, Long> age;
	public static volatile SingularAttribute<Geek, TypeGenre> genre;
	public static volatile SetAttribute<Geek, Interet> interet;
}
