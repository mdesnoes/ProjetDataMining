import java.io.IOException;
import java.util.List;

public class main {

	public static void main(String[] args) throws IOException{

		FichierUtils fichEntreprises = new FichierUtils("data/scenarios/liste_entreprises/Liste Ent3.txt");
		
		List<String> entreprises = fichEntreprises.getLignes();
		entreprises.remove(0); // On supprime la première ligne qui correspond au nombre d'entreprises
		entreprises.forEach(entreprise ->
			System.out.println(entreprise)
		);
		
		ListeBase listeBase = new ListeBase("data/scenarios/liste_bases/Liste Bases3.txt");
		Glouton glouton = new Glouton(entreprises, listeBase);
		
		List<Base> basesOpti = glouton.execute();
		
		
		
		//BRANCH & BOUND
		BranchAndBound Bb = new BranchAndBound(entreprises);
		Bb.execute();
	}

}
