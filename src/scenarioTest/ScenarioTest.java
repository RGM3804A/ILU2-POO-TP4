package scenarioTest;

import produit.*;
import personnages.Gaulois;
import villageGaulois.Etal;
import villageGaulois.IEtal;


public class ScenarioTest {
	public static void main(String[] args) {
		
		
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix",9);
		Gaulois obelix = new Gaulois("Obélix",20);
		Gaulois asterix = new Gaulois("Asterix", 6);
		
		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);
		
		Sanglier[] sangliersObelix = {sanglier1, sanglier2};
		Sanglier[] sangliersAsterix = {sanglier3, sanglier4};
		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = {poisson1};
		
		Etal[] marche = new Etal[3];
		Etal etalSanglier = new Etal<>();
		Etal etalPoisson = new Etal<>();
		marche[0] = etalSanglier;
		marche[1] = etalPoisson;
		marche[2] = etalSanglier;
		marche[0].installerVendeur(asterix, (IEtal[]) sangliersAsterix , 10);
		marche[1].installerVendeur(ordralfabetix, (IEtal[]) poissons, 7);
		marche[0].installerVendeur(obelix, (IEtal[]) sangliersObelix , 8);
	}
	
}
