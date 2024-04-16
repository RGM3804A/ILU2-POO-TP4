package produit;

import personnages.Gaulois;

public class Sanglier extends Produit{
	private Gaulois chasseur;
	private int poids;
	
	public Sanglier(int poids,Gaulois chasseur) {
		super("Sanglier",Unite.GRAMME);
		this.chasseur = chasseur;
		this.poids = poids;
	}
	
	public String getDescription() {
		return "Sanglier de " + poids + "kg chassé par " + chasseur.getNom();
	}
	
	public int calculerPrix(int prix) {
		return (prix*poids)/1000;
	}
}
