import java.util.List;

public class Base {

    private String nomBase;
    private int cout;
    private int nbElements;
    private List<String> entreprises;

    public Base(String nomBase, int cout, int nbElements, List<String> entreprises) {
        this.nomBase = nomBase;
        this.cout = cout;
        this.nbElements = nbElements;
        this.entreprises = entreprises;
    }
    
    public int compterEntreprises(List<String> entreprises) {
    	int nb = 0;
    	
    	for(String ent : entreprises) {
    		if(this.entreprises.contains(ent)) {
    			++nb;
    		}
    	}
    	
    	return nb;
    }

	//###############################################################################################################
	//				GETTERS AND SETTERS
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

    public String getNomBase() {
        return nomBase;
    }

    public void setNomBase(String nomBase) {
        this.nomBase = nomBase;
    }
	//###############################################################################################################
}
