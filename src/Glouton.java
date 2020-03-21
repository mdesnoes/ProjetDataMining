
import java.util.ArrayList;
import java.util.List;

public class Glouton {
	
	private List<String> entreprises;
	private ListeBase listeBases;
		
	public Glouton(List<String> entreprises, ListeBase listeBases) {
		this.entreprises = entreprises;
		this.listeBases = listeBases;
	}
	
	public List<Base> execute() {
		
		List<Base> listBaseOpti = new ArrayList<Base>();
		
		Base baseOpti = null; // La base ayant le coût le plus optimal pour l'entreprise courante
		
		do {
			baseOpti = choixGlouton(this.entreprises, this.listeBases);
			
			// On supprime la base qui a été choisi pour ne pas la parcourir plusieurs fois
			this.listeBases.getListeBases().remove(baseOpti);

			// Et on supprime les entreprises qui sont gérer
			for(String ent : baseOpti.getEntreprises()) {
				this.entreprises.remove(ent);
			}
			
			//On ajoute la base a la liste des bases opti
			listBaseOpti.add(baseOpti);
		}
		while(!this.entreprises.isEmpty());		
		
		return listBaseOpti;
	}
	
	// Retourne la base qui contient le plus d'entreprise recherché
	
	// Premier critére le nombre d'entreprise presente dans la base
	// Si égalité alors celle qui a le cout minimal
	private Base choixGlouton(List<String> entreprises, ListeBase listeBase) {
		Base baseChoisi = listeBase.getListeBases().get(0);
		
		int nbEntreprise = 0;
		for(Base base : listeBase.getListeBases()) {
			
			int nbEntrepriseBase = base.compterEntreprises(entreprises);
			if(nbEntrepriseBase > nbEntreprise) {
				nbEntreprise = nbEntrepriseBase;
				baseChoisi = base;
			} else {
				if(nbEntreprise == nbEntrepriseBase) {
					if(baseChoisi.getCout() > base.getCout()) {
						baseChoisi = base;
					}
				}
			}
			
		}
		
		return baseChoisi;
	}

}
