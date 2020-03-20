import java.io.IOException;
import java.util.List;

public class BranchAndBound {
	private List<String> entreprisesDemandees;
	private List<String> basesDemandees;

	public BranchAndBound(List<String> entreprisesDemandees, List<String> basesDemandees) {
		this.entreprisesDemandees=entreprisesDemandees;
		this.basesDemandees=basesDemandees;
	}

	public void execute() {
		//TEST
		entreprisesDemandees.forEach(entreprise -> System.out.println(entreprise));
		basesDemandees.forEach(base -> System.out.println(base));
		
		//RECUPERATION DU NOMBRE DE BASES
		int nbBasesDemandees = Integer.parseInt(basesDemandees.get(0));
		basesDemandees.remove(0);
		
		
		Noeud noeudCourant = new Noeud();
		AjoutEnfants(noeudCourant,0);

		
	}
	
	public void AjoutEnfants(Noeud noeudCourant, int indice) {
		FichierUtils fichBases = new FichierUtils("data/bases/"+basesDemandees.get(indice));
		List<String> baseCouranteLignes;
		Base baseCourante = null;
			
		try {
			baseCouranteLignes = fichBases.getLignes();
			baseCourante = new Base(baseCouranteLignes,basesDemandees.get(indice).split("\\.")[0]);
				
				
			//tests
			/*
				System.out.println(baseCourante.getNom().toUpperCase());
				System.out.println("######### "+baseCourante.getCout() );
				System.out.println("######### "+baseCourante.getNbElements() );
				System.out.println("######### "+baseCourante.getEntreprises() );
				System.out.println();
			*/				
		} catch (IOException e) {e.printStackTrace();}
			
			
		Noeud droit = noeudCourant;
		Noeud gauche = new Noeud(noeudCourant.getEntreprises(),noeudCourant.getCout(),noeudCourant.getBases(),baseCourante);
		noeudCourant.Afficher();
			
		AjoutEnfants(gauche,++indice);
		AjoutEnfants(droit,++indice);
		
	}
	
	
	/*
	 * 
	 * Au parcours de l'arbre on doit verifier :
	 * 		Si le noeud possède toutes les entreprises, Si le cout est plus faible que le cout courant on sauvegarde le noeud et on arrête le parcours de cette branche
	 * 													Sinon on arrête la branche
	 * 		Sinon on continue la branche
	 */
}
