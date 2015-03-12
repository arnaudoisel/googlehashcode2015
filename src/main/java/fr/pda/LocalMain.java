package fr.pda;

import fr.pda.bean.Serveur;

/**
 * Created by Arnaud on 12/03/15.
 */
public class LocalMain {

    public static void main(String[] args) {

        Serveur serveur1 = new Serveur(new String[]{"30","40"});
        System.out.println(serveur1.ratio);
        Serveur serveur2 = new Serveur(new String[]{"50","40"});
        System.out.println(serveur2.ratio);
        System.out.println(Double.valueOf(serveur1.ratio - serveur2.ratio));

        System.out.println(serveur1.compareTo(serveur2));
    }

}
