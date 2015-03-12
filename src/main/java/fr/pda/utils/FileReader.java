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
            while (scanner.hasNextLine()){
            	String ligne = scanner.nextLine();
            	if (nb_ligne==0) {
            		centre = new Centre(ligne.split(" "));
            		log(centre.toString());
            	}
            	if (nb_ligne<=1+centre.nbIndispo) {
            		String[] indispo = ligne.split(" ");
            		lServeur.add(new Serveur(Integer.valueOf(indispo[0]),Integer.valueOf(indispo[1])));
            	}
            	lServeur.add(new Serveur(ligne.split(" ")));
                //process each line in some way
                log(ligne);
                nb_ligne++;
            }
        }
        
        //algo
        List<Serveur> lsorted = ServeurUtils.sortByRatio(lServeur);
        
        
        for (Serveur serveur : lServeur) {
        	if (!serveur.indispo) {
				if (serveur.use) {
					aLines.add(String.valueOf(serveur.y) + " " + String.valueOf(serveur.x) + " " + String.valueOf(serveur.groupe));
				} else {
					aLines.add("x");
				}
        	}
		}
        
        FileWriter.writeLargerTextFile("out.txt", aLines);
        
    }

    private static void log(Object aMsg){
        System.out.println(String.valueOf(aMsg));
    }

}
