package scenarioTest;

import personnages.Gaulois;
import villageGaulois.IVillage;
import produit.*;
import villagegauloisIsOld.DepenseMarchand;
import villageGaulois.Etal;
import villageGaulois.IEtal;

public class Scenario {

	public static void main(String[] args) {

		// TODO Partie 4 : creer de la classe anonyme Village
		IVillage village = new IVillage() {
			private static final String nom = "Les Irréductibles";
			private Gaulois chef = new Gaulois("Abraracourcix",7);
			private IEtal[] marchand;
			private int nbVendeur = 0;
			
			@Override
			public<P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix) {
				etal.installerVendeur(vendeur, produit, prix);
				marchand[nbVendeur] = etal;
				this.nbVendeur++;
			}
			
			@Override
			public DepenseMarchand[] acheterProduit(String produit,int quantiteSouhaitee) {
				DepenseMarchand[] depenseMarchand = new DepenseMarchand[quantiteSouhaitee];
				int nbDepense = 0;
				for(int i=0;i<nbVendeur && quantiteSouhaitee > 0;i++) {
					int qteeVendu = marchand[i].contientProduit(produit, quantiteSouhaitee);
					if(qteeVendu>0) {
						double sommeDepensee = marchand[i].acheterProduit(quantiteSouhaitee);
						DepenseMarchand depense = new DepenseMarchand(marchand[i].getVendeur(),qteeVendu,produit,sommeDepensee);
						depenseMarchand[nbDepense] = depense;
						nbDepense++;
						quantiteSouhaitee = quantiteSouhaitee - qteeVendu;
					}
				}
				
				return depenseMarchand;
			}
		};
		
		// fin

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		IEtal etalSanglierObelix = new Etal<>();
		IEtal etalSanglierAsterix = new Etal<>();
		IEtal etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		DepenseMarchand[] depense = village.acheterProduit("sanglier", 3);

		for (int i = 0; i < depense.length && depense[i] != null; i++) {
			System.out.println(depense[i]);
		}

		System.out.println(village);

	}
	/*Village village = new Village() implements IVillage {
		private static final String nom = "Les Irréductibles";
		private Gaulois chef = new Gaulois("Abraracourcix",7);
		private int nbVendeur = 0;
		
		@Override
		public<T extends Produit> boolean installerVendeur(Etal<T> etal, Gaulois vendeur, T[] produit, int prix) {
			etal.installerVendeur(vendeur, produit, prix);
			this.nbVendeur++;
		}
		
		@Override
		public DepenseMarchand[] acheterProduit(String produit,int quantiteSouhaitee) {
			DepenseMarchand[] depenseMarchand = new DepenseMarchand[quantiteSouhaitee];
			int nbDepense = 0;
			return depenseMarchand;
		}
	};*/
}
