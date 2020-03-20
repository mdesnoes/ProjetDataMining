
import java.util.ArrayList;
import java.util.List;

public class Glouton {
	
	private List<String> entreprises;
	private ListeBase bases;
	
	public Glouton(List<String> entreprises, ListeBase bases) {
		this.entreprises = entreprises;
		this.bases = bases;
	}

	// On fait le choix glouton en fonction du coût d'une base
	public List<Base> execute() {
		
		List<Base> baseOpti = new ArrayList<Base>();
		
 		int coutTotal = 0;	// Le coût total des informations sur les entreprises
		int cout = 1000;	// Le coût pour avoir des informations sur l'entreprise courante
		for(String entreprise : this.entreprises) {
			
			for(Base base : this.bases.getListeBases()) {
				if(base.getEntreprises().contains(entreprise)) {
					
					if(base.getCout() < cout) {
						coutTotal -= cout; // on enleve au coût total, l'ancien cout
						cout = base.getCout(); // nouveau cout
						coutTotal += cout; // on ajoute au cout total, le nouveau cout
						
						if(!baseOpti.isEmpty()) {
							baseOpti.remove(baseOpti.size() - 1); // on supprime la derniere base de la liste
						}
						baseOpti.add(base); // on la remplace par la nouvelle qui est plus optimale
					}
				}
			}
			
			cout = 0;
		}
		
		return baseOpti;
	}
	

	public List<String> getEntreprises() {
		return entreprises;
	}
	public void setEntreprises(List<String> entreprises) {
		this.entreprises = entreprises;
	}
	public ListeBase getBases() {
		return bases;
	}
	public void setBases(ListeBase bases) {
		this.bases = bases;
	}
}
