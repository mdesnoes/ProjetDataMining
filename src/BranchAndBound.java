import java.util.List;

public class BranchAndBound {
	
	private static final int INFINI = Integer.MAX_VALUE;
	
	private List<String> entreprisesDemandees;
	private ListeBase basesDemandees;
	private Noeud noeudOptimale;

	public BranchAndBound(List<String> entreprisesDemandees, ListeBase basesDemandees) {
		this.entreprisesDemandees=entreprisesDemandees;
		this.basesDemandees=basesDemandees;
		this.noeudOptimale = new Noeud();
		this.noeudOptimale.setCout(INFINI);
	}

	public void execute() {
		/*
		//TEST
			entreprisesDemandees.forEach(entreprise -> System.out.println(entreprise));	
			basesDemandees.AfficherListe();
		*/
		
		Noeud noeudCourant = new Noeud();
		AjoutEnfants(noeudCourant,0);
		
		
		//AFFICHAGE
		if(noeudOptimale.getCout() == INFINI) {
			System.out.println("Impossible de couvrir toutes les entreprises avec ces bases");
		}
		else {
			System.out.println("Bases optimales : ");
		  for(Base b :noeudOptimale.getBases()) {
			  System.out.println(b.getNomBase() + " ( cout : " + b.getCout() + " )");
      }
			System.out.println("Le cout optimal pour obtenir les informations sur les entreprise est : "+noeudOptimale.getCout());
		}
	}
	
	
	
	public void AjoutEnfants(Noeud noeudCourant, int indice) {
		Base baseCourante = basesDemandees.get(indice);
		/*
		//TEST
			System.out.println("TAILLE : "+noeudCourant.getEntreprises().size());
			System.out.println(baseCourante.getNbElements());
			noeudCourant.Afficher();	
		*/
		
		if(++indice<basesDemandees.getNbBase()) {
			if(noeudCourant.PossedeEntreprises(entreprisesDemandees)) {
				if(noeudOptimale.getCout()>noeudCourant.getCout())
					noeudOptimale = noeudCourant;
			}else {			
				Noeud gauche = new Noeud(noeudCourant.getEntreprises(),noeudCourant.getCout(),noeudCourant.getBases(),baseCourante);
				Noeud droit = new Noeud(noeudCourant);
				
				AjoutEnfants(gauche,indice);	
				AjoutEnfants(droit,indice);
			}
		}
		
	}
	
	
	/*
	 * 
	 * Au parcours de l'arbre on doit verifier :
	 * 		Si le noeud possède toutes les entreprises, Si le cout est plus faible que le cout courant on sauvegarde le noeud et on arrête le parcours de cette branche
	 * 													Sinon on arrête la branche
	 * 		Sinon on continue la branche
	 */
}
