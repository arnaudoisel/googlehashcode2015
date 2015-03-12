package fr.pda.bean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Arnaud on 12/03/15.
 */
public class Group {

    public int id;

    private Set<Serveur> serveurs = new HashSet<Serveur>();

    private int[] capacites;

    public Group(int nbRangees, int id) {
    	this.id = id;
        capacites = new int[nbRangees];
        for (int i = 0; i < nbRangees; i++) {
        	capacites[i] = 0;
		}
    }

    public void add(Serveur serveur, int rangee) {
        serveurs.add(serveur);
        capacites[rangee] += serveur.nbCapacite;
    }

    public static Group getGroupFaible(Group[] groups) {
    	Group groupMin = null;
    	for (Group group : groups) {
			if(group.getSommeCapaciteSaufPlusForte() == -1) return group;
			
			if (groupMin == null || groupMin.getSommeCapaciteSaufPlusForte()>group.getSommeCapaciteSaufPlusForte()) {
				groupMin = group;
			}
		}
        return groupMin;
    }

    public int getSommeCapaciteSaufPlusForte() {
    	int min = -1;
    	for (int i = 0; i < capacites.length; i++) {
    		if (min==-1 || min>capacites[i]) {
    			min = capacites[i];
    		}
		}
        return min;
    }


}
