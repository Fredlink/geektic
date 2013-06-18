package com.ninja_squad.geektic;

public enum TypeInteret {
	C("c"),
	JAVA("Java"),
	PHP("php"),
	ACTION("Action"),
	AVENTURE("Aventure"),
	RPG("Jeux de rôles"),
	REFLEXION("Réflexion"),
	STRATEGIE("Stratégie");
	
	private String displayName;
	
	TypeInteret(){
		
	}
	
	TypeInteret(String displayName) {
        this.displayName = displayName;
    }
	
	public static TypeInteret[] valuesLanguages(){
		TypeInteret[] langs = new TypeInteret[3];
		langs[0] = TypeInteret.C;
		langs[1] = TypeInteret.JAVA;
		langs[2] = TypeInteret.PHP;
		return langs;
	}

	public static TypeInteret[] valuesJv(){
		TypeInteret[] langs = new TypeInteret[5];
		langs[0] = TypeInteret.ACTION;
		langs[1] = TypeInteret.AVENTURE;
		langs[2] = TypeInteret.RPG;
		langs[3] = TypeInteret.REFLEXION;
		langs[4] = TypeInteret.STRATEGIE;
		return langs;
	}
	
    public String displayName() { return displayName; }

    // Optionally and/or additionally, toString.
    @Override public String toString() { return displayName; }
}
