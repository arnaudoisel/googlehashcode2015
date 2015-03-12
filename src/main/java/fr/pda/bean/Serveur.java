package fr.pda.bean;

/**
 * @author BRICONO
 *
 */
public class Serveur {
	
	public boolean indispo;
	public boolean use;
	public int nbEmplacement;
	public int nbCapacite;
	
	public int x;
	public int y;
	
	public int groupe;
	
	
	/**
	 * Cr�ation serveur
	 * @param tab
	 */
	public Serveur(String[] tab){
		indispo = false;
		nbEmplacement = Integer.valueOf(tab[0]);
		nbCapacite = Integer.valueOf(tab[1]);
	}
	
	/**
	 * Cr�ation indispo
	 * @param tab
	 */
	public Serveur(int x, int y){
		indispo = true;
		this.x=x;
		this.y=y;
	}


}
