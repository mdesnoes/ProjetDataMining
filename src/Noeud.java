import java.util.ArrayList;
import java.util.List;

public class Noeud {
	private int cout;
	private ArrayList<String> entreprises;
	private ArrayList<Base> bases;
	
	//CREATION D'UN NOEUD NULL
	public Noeud() {
		super();
		int cout=0;
		this.setEntreprises(new ArrayList<String>());
		this.setBases(new ArrayList<Base>());
	}
	
	
	//CREATION D'UN NOEUD AVEC AJOUT DE BASE
	public Noeud(ArrayList<String> e, int c, ArrayList<Base> ba, Base newBase) {
		super();
		//ajout entreprises
		entreprises = new ArrayList<String>();
		entreprises.addAll(e);
		entreprises.addAll(newBase.getEntreprises());
		
		//ajout bases
		this.bases = new ArrayList<Base>();
		for(Base b : ba) {
			bases.add(b);
		}
		bases.add(newBase);
		
		cout=c+newBase.getCout();
	}	
	
	//CREATION D'UN NOEUD EN COPIE D'UN AUTRE
	public Noeud(Noeud copie) {
		super();
		this.cout = copie.cout;
		
		//copie entreprises
		entreprises = new ArrayList<String>();
		for(String e : copie.getEntreprises()) {
			this.entreprises.add(e);
		}

		//copie bases
		this.bases = new ArrayList<Base>();
		for(Base b : copie.getBases()) {
			bases.add(b);
		}
	}
	
	
	public boolean PossedeEntreprises(List<String> entreprisesDemandees) {
		for(String entdem : entreprisesDemandees) {
			if(!entreprises.contains(entdem))
				return false;
		}
		return true;
	}
	
	
	public void Afficher() {
		System.out.print("COUT : "+getCout());
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
