package fr.pda.bean;

public class Rangee {
	
	public String[] tUse;
	
	public Rangee(int taille){
		tUse = new String[taille];
	}
	
	public void addIndispo(int x){
		tUse[x] = "x";
	}
	
	public int addServeur(Serveur serveur){
		int taille = serveur.nbEmplacement;
		for (int i=0; i<tUse.length; i++){
			if(tUse[i]==null){
				boolean ok = true;
				for (int j = i; j < i+taille; j++) {
					if (j>=tUse.length || tUse[j]!=null) {
						ok=false;
					}
				}
				if (ok) {
					for (int j = i; j < i+taille; j++) {
						tUse[j]=String.valueOf(serveur.id);
					}
					return i;
				}
			}
		}
		return -1;
	}
	
	public String toString(){
		String str = "";
		for (String string : tUse) {
			str+=" "+ string;
		}
		return str;
	}

}
