package com.company;

public class Case {
	
	//Définition des cases
	public static final int Sol = 0;
	public static final int Mur = 1;
	public static final int Caisse = 2;
	public static final int CaisseGoal = 3;
	public static final int Goal = 4;
	public static final int Perso = 5;
	public static final int PersoGoal = 6;
	
	private int LaCase;
	
	//Variable de classe Case
	
	public Case(char cas){
		this.LaCase=cas;
	}

	public int getLaCase() {
		return LaCase;
	}

	public void setLaCase(int laCase) {
		LaCase = laCase;
	}
	
}
