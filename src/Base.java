import java.util.ArrayList;
import java.util.List;

public class Base {
	String nom;
	int cout;
	int nbElements;
	private ArrayList<String> entreprises;
	
	
	public Base(List<String> baseCouranteLignes,String nom) {
		super();
		this.nom=nom;
		this.cout = Integer.parseInt(baseCouranteLignes.get(0));
		this.nbElements = Integer.parseInt(baseCouranteLignes.get(1));
		
		this.entreprises = new ArrayList<String>();
		for(int i=2;i<baseCouranteLignes.size();++i) {
			this.entreprises.add(baseCouranteLignes.get(i));
		}
	}	
	
	public Base(int cout, int nbElements, ArrayList<String> entreprises,String nom) {
		super();
		this.nom=nom;
		this.cout = cout;
		this.nbElements = nbElements;
		this.entreprises = entreprises;
	}

	//###############################################################################################################
	//				GETTERS AND SETTERS
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCout() {
		return cout;
	}
	
	
	public void setCout(int cout) {
		this.cout = cout;
	}


	public int getNbElements() {
		return nbElements;
	}


	public void setNbElements(int nbElements) {
		this.nbElements = nbElements;
	}


	public ArrayList<String> getEntreprises() {
		return entreprises;
	}


	public void setEntreprises(ArrayList<String> entreprises) {
		this.entreprises = entreprises;
	}
	//###############################################################################################################
}
