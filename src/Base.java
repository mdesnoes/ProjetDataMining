import java.util.List;

public class Base {	
    private int cout;
    private int nbElements;
    private List<String> entreprises;

    public Base(int cout, int nbElements, List<String> entreprises) {
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
    public List<String> getEntreprises() {
        return entreprises;
    }
    public void setEntreprises(List<String> entreprise) {
        this.entreprises = entreprise;
    }
    public int getNbElements() {
        return nbElements;
    }
    public void setNbElements(int nbElements) {
        this.nbElements = nbElements;
    }
}
