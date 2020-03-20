import java.util.ArrayList;

public class Base {
	int cout;
	int nbElements;
	private ArrayList<String> entreprises;
	
	
	public Base(int cout, int nbElements, ArrayList<String> entreprises) {
		super();
		this.cout = cout;
		this.nbElements = nbElements;
		this.entreprises = entreprises;
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
}
