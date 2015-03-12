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

    public Group(int nbRangees) {
        capacites = new int[nbRangees];
    }

    public void add(Serveur serveur, int rangee) {
        serveurs.add(serveur);
    }

    public static Group getGroupFaible(List<Group> groups) {
        return null;
    }

    public int getSommeCapaciteSaufPlusForte() {
        return -1;
    }


}
