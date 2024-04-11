package villageGaulois;

import personnages.Gaulois;

public class Etal<T extends IEtal> implements IEtal {
	private Gaulois vendeur;
	private T[] produits;
	private int nbProduit;
	private int prixProduit;
	
	public void installerVendeur(Gaulois vendeur, T[] produit, int prix) {
		this.vendeur = vendeur;
		this.prixProduit = prix;
		this.nbProduit = produit.length;
		this.produits = produit;
	}
	
	@Override
	public Gaulois getVendeur() {
		// TODO Auto-generated method stub
		return vendeur;
	}

	@Override
	public double donnerPrix() {
		// TODO Auto-generated method stub
		return prixProduit;
	}

	@Override
	public int contientProduit(String produit, int quantiteSouhaitee) {
		int quantiteAVendre = 0;
		if (nbProduit != 0 && this.produits[0].getNom().equals(produit)) {
			if (nbProduit >= quantiteSouhaitee) {
				quantiteAVendre = quantiteSouhaitee;
			} else {
				quantiteAVendre = nbProduit;
			}
		}
		return quantiteAVendre;
	}

	@Override
	public double acheterProduit(int quantiteSouhaitee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String etatEtal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getNom();{
		return produits;
	}

}
