package villageGaulois;

import personnages.Gaulois;

public interface IEtal {
	public Gaulois getVendeur();
	public double donnerPrix();
	public int contientProduit(String produit, int quantiteSouhaitee);
	public double acheterProduit(int quantiteSouhaitee);
	public String etatEtal();
}
