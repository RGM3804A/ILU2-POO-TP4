package produit;

public class Poisson extends Produit {
	private String datePeche;
	
	public Poisson(String datePeche) {
		super("poisson",Unite.GRAMME);
		this.datePeche = datePeche;
	}
	
	public String getDescription() {
		return "Poisson pêchès " + datePeche;
	}
}
