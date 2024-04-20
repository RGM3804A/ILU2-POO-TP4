package villageGaulois;

import personnages.Gaulois;
import produit.Produit;
import villagegauloisIsOld.DepenseMarchand;

public interface IVillage {
	
	public <P extends Produit> boolean installerVendeur(Etal<P> etal,Gaulois vendeur, P[] produit, int prix);
	public DepenseMarchand[] acheterProduit(String produit,int quantiteSouhaitee);
}
