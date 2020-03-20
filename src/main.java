import java.io.IOException;
import java.util.List;

public class main {

	public static void main(String[] args) throws IOException{

		FichierUtils fichEntreprises = new FichierUtils("data/scenarios/liste_entreprises/Liste Ent1.txt");
		List<String> entreprisesDemandees = fichEntreprises.getLignes();
		
		
		FichierUtils fichBases = new FichierUtils("data/scenarios/liste_bases/Liste Bases1.txt");
		List<String> basesDemandees = fichBases.getLignes();

		
		//BRANCH & BOUND
		BranchAndBound Bb = new BranchAndBound(entreprisesDemandees,basesDemandees);
		Bb.execute();
	}

}
