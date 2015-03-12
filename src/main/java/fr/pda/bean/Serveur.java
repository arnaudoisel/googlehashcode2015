package fr.pda.bean;

/**
 * @author BRICONO
 *
 */
public class Serveur implements Comparable<Serveur> {


    public boolean indispo;
	public boolean use;
	public int nbEmplacement;
	public int nbCapacite;
	public double ratio;

	public int x;
	public int y;
	
	public int groupe;
	public int id;
	
	
	/**
	 * Cr�ation serveur
	 * @param tab
	 */
	public Serveur(String[] tab, int id){
		indispo = false;
		nbEmplacement = Integer.valueOf(tab[0]);
		nbCapacite = Integer.valueOf(tab[1]);
        ratio = (double)nbCapacite / (double)nbEmplacement;
        this.id = id;
	}
	
	/**
	 * Cr�ation indispo
	 */
	public Serveur(int x, int y){
		indispo = true;
		this.x=x;
		this.y=y;
	}


    @Override
    public int compareTo(Serveur o) {
        if (ratio == o.ratio)
            return 0;
        return (int)Math.round(ratio - o.ratio);
    }

    @Override
    public String toString() {
        return "Serveur{" +
                "indispo=" + indispo +
                ", use=" + use +
                ", nbEmplacement=" + nbEmplacement +
                ", nbCapacite=" + nbCapacite +
                ", ratio=" + ratio +
                ", x=" + x +
                ", y=" + y +
                ", groupe=" + groupe +
                '}';
    }
}
