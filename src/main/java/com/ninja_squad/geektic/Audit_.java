package com.ninja_squad.geektic;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-01-04T16:54:52.471+0100")
@StaticMetamodel(Audit.class)
public class Audit_ {
	public static volatile SingularAttribute<Audit, Long> id;
	public static volatile SingularAttribute<Audit, Long> idGeek;
	public static volatile SingularAttribute<Audit, String> dateVisite;
	public static volatile SingularAttribute<Audit, String> ip;
}
