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
		Etal etalSanglier1 = new Etal<>();
		Etal etalSanglier2 = new Etal<>();
		Etal etalPoisson = new Etal<>();
		marche[0] = etalSanglier1;
		marche[1] = etalSanglier2;
		marche[2] = etalPoisson;
		
		marche[0].installerVendeur(asterix, sangliersAsterix , 10);
		marche[1].installerVendeur(obelix, sangliersObelix , 8);
		marche[2].installerVendeur(ordralfabetix, poissons, 7);
		
		StringBuilder chaine = new StringBuilder();
		chaine.append("ETAT MARCHE\n");
		chaine.append(marche[0].etatEtal() + "\n");
		chaine.append(marche[1].etatEtal() + "\n");
		chaine.append(marche[2].etatEtal() + "\n");
		int nbSanglier = 0;
		int sanglierRequis = 3;
		
		int sanglierAchetable = marche[0].contientProduit("Sanglier",sanglierRequis-nbSanglier);
		nbSanglier += sanglierAchetable;
		double prixPayee = marche[0].acheterProduit(sanglierAchetable);
		chaine.append("A l'étal 0 je paye " + prixPayee + " sous.\n");
		
		sanglierAchetable = marche[1].contientProduit("Sanglier",sanglierRequis-nbSanglier);
		nbSanglier += sanglierAchetable;
		prixPayee = marche[1].acheterProduit(sanglierAchetable);
		chaine.append("A l'étal 1 je paye " + prixPayee + " sous.\n");//prix
		
		chaine.append("Je voulais " + sanglierRequis +" sangliers, j'en ai acheté " + nbSanglier + ".\n\n");
		chaine.append("ETAT MARCHE\n");
		chaine.append(marche[0].etatEtal() + "\n");
		chaine.append(marche[1].etatEtal() + "\n");
		chaine.append(marche[2].etatEtal() + "\n");
		System.out.println(chaine.toString());
	}
	
}
