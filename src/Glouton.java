
import java.util.ArrayList;
import java.util.List;

public class Glouton {
	
	private static final int INFINI = Integer.MAX_VALUE;

	private List<String> entreprises;
	private ListeBase bases;
		
	public Glouton(List<String> entreprises, ListeBase bases) {
		this.entreprises = entreprises;
		this.bases = bases;
	}

	// On fait le choix glouton en fonction du coût d'une base
	public List<Base> execute() {
		
		List<Base> listBaseOpti = new ArrayList<Base>();
		
		int cout = INFINI;	// Le coût pour avoir des informations sur l'entreprise courante
		Base baseOpti = null; // La base ayant le coût le plus optimal pour l'entreprise courante
		
		for(String entreprise : this.entreprises) {
			
			for(Base base : this.bases.getListeBases()) {
				if(base.getEntreprises().contains(entreprise)) {
					
					if(base.getCout() < cout) {
						cout = base.getCout(); // Nouveau coût optimal
						baseOpti = base; // Nouvelle base optimal
					}
				}
			}
			
			if(!listBaseOpti.contains(baseOpti)) {
				listBaseOpti.add(baseOpti);
			}
			cout = INFINI;
		}
		
		return listBaseOpti;
	}

}
