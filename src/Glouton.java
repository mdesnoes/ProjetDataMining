
import java.util.ArrayList;
import java.util.List;

public class Glouton {
	
	private List<String> entreprises;
	private ListeBase listeBases;
		
	public Glouton(List<String> entreprises, ListeBase listeBases) {
		this.entreprises = entreprises;
		this.listeBases = listeBases;
	}
	
	public void execute() {
		List<Base> listBaseOpti = new ArrayList<Base>();
		boolean quitter = false;
		
		do {
			Base baseOpti = choixGlouton(this.entreprises, this.listeBases);
			
			/* Si on ne trouve aucune base opti, on quitte l'algorithme */
			if(baseOpti == null) {
				quitter = true;
				break;
			}
			
			this.listeBases.getListeBases().remove(baseOpti);

			this.entreprises.removeAll(baseOpti.getEntreprises());
			
			/* On ajoute la base a la liste des bases optimales */
			listBaseOpti.add(baseOpti);
		}
		while(!this.entreprises.isEmpty());		
		
		
		/* AFFICHAGE */
		if(quitter) {
			System.out.println("Impossible de couvrir toutes les entreprises avec ces bases");
		} else {
			int coutTotal = 0;
			System.out.println("Bases optimales : ");
			for(Base base : listBaseOpti) {
				coutTotal += base.getCout();
				System.out.println(base.getNomBase() + " ( cout : "+base.getCout() + " )");
			}
			System.out.println("Le cout optimal pour obtenir les informations sur les entreprise est : " + coutTotal);
		}
	}
		
	/* Critere de choix : Le nombre d'entreprise recherché presente dans la base
	 * et si égalité alors celle qui a le cout minimal
	 */
	private Base choixGlouton(List<String> entreprises, ListeBase listeBase) {
		Base baseChoisi = null;
		
		int nbEntreprise = 0;
		for(Base base : listeBase.getListeBases()) {
			
			int nbEntrepriseBase = base.compterEntreprises(entreprises);
			if(nbEntrepriseBase > nbEntreprise) {
				nbEntreprise = nbEntrepriseBase;
				baseChoisi = base;
			} else {
				if(nbEntreprise == nbEntrepriseBase) {
					if(baseChoisi != null) {
						if(baseChoisi.getCout() > base.getCout()) {
							baseChoisi = base;
						}
					}
				}
			}
		}
		
		return baseChoisi;
	}

}
