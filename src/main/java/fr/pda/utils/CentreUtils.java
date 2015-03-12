/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.pda.utils;

import fr.pda.bean.Centre;
import fr.pda.bean.Rangee;
import fr.pda.bean.Serveur;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Llaz
 */
public class CentreUtils {
    
    public static void fillHoles(List<Serveur> serveurs, Centre centre) {
        
        List<Serveur> serveursDispo = new ArrayList<Serveur>();
        for (Serveur s : serveurs){
            if (!s.indispo ) serveursDispo.add(s);
        }
        
        //for (Rangee r : centre.tRangee){
        for (int k = 0; k < centre.tRangee.length; k++){
                
            Rangee r = centre.tRangee[k];
            for(int j = 0; j < centre.nbEmplacement; j++) {
                
                if (!r.tUse[j]) {
                    
                    for (Serveur ss : serveursDispo) {
                        if (ss.nbEmplacement == 1) {
                            ss.x = j;
                            ss.y = k;
                        }
                    }       
                } 
            }
        }
    }
    
}
