import java.util.ArrayList;

public class Noeud {
	private int cout;
	private ArrayList<String> entreprises;
	private ArrayList<Base> bases;
	private Noeud gauche, droit;
	
	//CREATION D'UN NOEUD NULL
	public Noeud() {
		super();
		int cout=0;
		this.setEntreprises(new ArrayList<String>());
		this.setBases(new ArrayList<Base>());
		this.gauche = null;
		this.droit = null;
	}
	
	//CREATION D'UN NOEUD SIMPLE (normalement inutile)
	public Noeud(ArrayList<String> entreprises, int cout, ArrayList<Base> bases) {
		super();
		this.setEntreprises(entreprises);
		this.setCout(cout);
		this.setBases(bases);
		this.gauche = null;
		this.droit = null;
	}	
	
	//CREATION D'UN NOEUD AVEC AJOUT DE BASE
	public Noeud(ArrayList<String> entreprises, int cout, ArrayList<Base> bases, Base newBase) {
		super();
		this.setEntreprises(entreprises);
		this.getEntreprises().addAll(newBase.getEntreprises());
		

		this.setBases(bases);
		this.getBases().add(newBase);
		
		this.setCout(cout+newBase.getCout());
		
		this.gauche = null;
		this.droit = null;
	}	
	
	
	public void Afficher() {
		System.out.print(getCout());
		System.out.println();
	}
	
	
	
	//###############################################################################################################
	//				GETTERS AND SETTERS
	public ArrayList<String> getEntreprises() {
		return entreprises;
	}

	public void setEntreprises(ArrayList<String> entreprises) {
		this.entreprises = entreprises;
	}

	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
	}

	public ArrayList<Base> getBases() {
		return bases;
	}

	public void setBases(ArrayList<Base> bases) {
		this.bases = bases;
	}
	//###############################################################################################################
}
