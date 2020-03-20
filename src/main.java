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
		entreprises3.remove(0);
		
		/*entreprises3.forEach(entreprise ->
			System.out.println(entreprise)
		);*/

		ListeBase listeBase3 = new ListeBase("Liste Bases3.txt");

		// GLOUTON
		Glouton glouton = new Glouton(entreprises3, listeBase3);
		List<Base> baseOpti = glouton.execute();
		baseOpti.forEach( base ->
			System.out.println(base.getCout())
		);
		
		// BRANCH & BOUND
		BranchAndBound Bb = new BranchAndBound(entreprises3);
		Bb.execute();
	}

}
