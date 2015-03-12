package fr.pda.bean;

public class Rangee {
	
	Boolean[] tUse;
	
	public Rangee(int taille){
		tUse = new Boolean[taille];
	}
	
	public void addIndispo(int x){
		tUse[x] = true;
	}

}
