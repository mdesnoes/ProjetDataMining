import java.io.IOException;
import java.util.List;

public class main {

	public static void main(String[] args) throws IOException{

		FichierUtils fichEntreprises = new FichierUtils("data/scenarios/liste_entreprises/Liste Ent1.txt");
		FichierUtils fichEntreprises2 = new FichierUtils("data/scenarios/liste_entreprises/Liste Ent2.txt");
		FichierUtils fichEntreprises3 = new FichierUtils("data/scenarios/liste_entreprises/Liste Ent3.txt");
		
		List<String> entreprises = fichEntreprises.getLignes();
		List<String> entreprises2 = fichEntreprises2.getLignes();
		List<String> entreprises3 = fichEntreprises3.getLignes();

		/*entreprises3.forEach(entreprise ->
			System.out.println(entreprise)
		);*/

		ListeBase listeBase = new ListeBase("Liste Bases3.txt");

		System.out.println("Cout : "+listeBase.getListeBases().get(0).getCout());
		System.out.println("nbElement : "+listeBase.getListeBases().get(0).getNbElements());
		System.out.println("Entreprises : ");
		listeBase.getListeBases().get(0).getEntreprises().forEach( ent ->
        System.out.println(ent)
    );
		
		Glouton glouton = new Glouton(entreprises, listeBase);
		List<Base> basesOpti = glouton.execute();
				
		// GLOUTON
		Glouton glouton = new Glouton(entreprises3);
		glouton.execute();

		// BRANCH & BOUND
		BranchAndBound Bb = new BranchAndBound(entreprises3);
		Bb.execute();
	}

}
