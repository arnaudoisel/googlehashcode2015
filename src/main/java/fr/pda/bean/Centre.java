package fr.pda.bean;

public class Centre {
	
	public int nbRangee;
	public int nbEmplacement;
	public int nbIndispo;
	public int nbGroup;
	public int nbServeur;
	
	public Rangee[] tRangee;
	public Group[] tGroup;
	
	public Centre (String[] tab){
		nbRangee = Integer.valueOf(tab[0]);
		nbEmplacement = Integer.valueOf(tab[1]);
		nbIndispo = Integer.valueOf(tab[2]);
		nbGroup = Integer.valueOf(tab[3]);
		nbServeur = Integer.valueOf(tab[4]);
		
		tRangee = new Rangee[nbRangee];
		for (int i = 0; i < nbRangee; i++) {
			tRangee[i] = new Rangee(nbEmplacement);
		}
		
		tGroup = new Group[nbGroup];
		for (int i = 0; i < nbGroup; i++) {
			tGroup[i] = new Group(nbRangee);
		}
	}
	
	public String toString(){
		return String.valueOf(nbRangee) + String.valueOf(nbEmplacement) + String.valueOf(nbIndispo) + String.valueOf(nbGroup) + String.valueOf(nbServeur);
	}

}
