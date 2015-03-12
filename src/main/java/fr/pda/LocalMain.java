package fr.pda;

import fr.pda.bean.Serveur;
import fr.pda.utils.ServeurUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arnaud on 12/03/15.
 */
public class LocalMain {

    public static void main(String[] args) {

        Serveur serveur1 = new Serveur(new String[]{"30","40"});
        System.out.println(serveur1.ratio);
        Serveur serveur2 = new Serveur(new String[]{"50","40"});
        System.out.println(serveur2.ratio);

        List<Serveur> serveurs = new ArrayList<Serveur>();
        serveurs.add(serveur1);
        serveurs.add(serveur2);
        System.out.println(ServeurUtils.sortByRatio(serveurs));
    }

}
