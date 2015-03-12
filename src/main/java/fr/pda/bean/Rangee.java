package fr.pda.bean;

public class Rangee {
	
	Boolean[] tUse;
	
	public Rangee(int taille){
		tUse = new Boolean[taille];
	}
	
	public void addIndispo(int x){
		tUse[x] = true;
	}
	
	public int addServeur(Serveur serveur){
		int taille = serveur.nbEmplacement;
		for (int i=0; i<tUse.length; i++){
			if(tUse[i]==null){
				boolean ok = true;
				for (int j = i; j < i+taille; j++) {
					if (tUse[j]!=null) {
						ok=false;
					}
				}
				if (ok) {
					for (int j = i; j < i+taille; j++) {
						tUse[j]=true;
					}
					return i;
				}
			}
		}
		return -1;
	}

}
