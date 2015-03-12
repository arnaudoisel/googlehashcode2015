package fr.pda.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pda.bean.Centre;
import fr.pda.bean.Group;
import fr.pda.bean.Rangee;
import fr.pda.bean.Serveur;

/**
 * Created by Arnaud on 09/03/15.
 */
public class FileReader {

    final static Charset ENCODING = StandardCharsets.UTF_8;

    public static void readLargerTextFile(String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        
        Centre centre = null;
        List<Serveur> lServeur = new ArrayList<Serveur>();
        List<String> aLines = new ArrayList<String>();
        
        try (Scanner scanner =  new Scanner(path, ENCODING.name())){
        	int nb_ligne=0;
        	int serveur=0;
            while (scanner.hasNextLine()){
            	String ligne = scanner.nextLine();
            	if (nb_ligne==0) {
            		centre = new Centre(ligne.split(" "));
            		log(centre.toString());
            	}else if (nb_ligne<1+centre.nbIndispo) {
            		String[] indispo = ligne.split(" ");
            		lServeur.add(new Serveur(Integer.valueOf(indispo[1]),Integer.valueOf(indispo[0])));
            	} else {
	            	lServeur.add(new Serveur(ligne.split(" "),serveur));
	            	serveur++;
            	}
            	nb_ligne++;
            }
        }
        
        for (Serveur serveur : lServeur) {
        	if (serveur.indispo) {
        		centre.tRangee[serveur.y].addIndispo(serveur.x);
        	}
		}
        
        //algo
        List<Serveur> lsorted = ServeurUtils.sortByRatio(lServeur);
        int noServer = 0;
        int j = 0;
        for (Serveur serveur : lsorted){
        	int colonne = -1;
        	colonne = centre.tRangee[noServer%centre.nbRangee].addServeur(serveur);
        	while (colonne==-1 && j<centre.nbRangee){
        		j++;
        		colonne = centre.tRangee[(noServer+j)%centre.nbRangee].addServeur(serveur);   		
        	}
        	if (colonne!=-1){
        	Group groupFaible = Group.getGroupFaible(centre.tGroup);
        	groupFaible.add(serveur, (noServer+j)%centre.nbRangee);
        	//Group.getGroupFaible(groups)
        	serveur.groupe=groupFaible.id;
        	serveur.y=(noServer+j)%centre.nbRangee;
        	serveur.x=colonne;
        	serveur.use=true;
        	noServer++;   
        	}
        }

        
        for (Serveur serveur : lServeur) {
        	if (!serveur.indispo) {
				if (serveur.use) {
					aLines.add(String.valueOf(serveur.id) +" " + String.valueOf(serveur.y) + " " + String.valueOf(serveur.x) + " " + String.valueOf(serveur.groupe));
				} else {
					aLines.add("x");
				}
        	}
		}
        
        FileWriter.writeLargerTextFile("out.txt", aLines);
        
        log("out");
        
        for (Rangee rangee : centre.tRangee) {
        	System.out.println(rangee.toString());
		}
    }

    private static void log(Object aMsg){
        System.out.println(String.valueOf(aMsg));
    }

}
