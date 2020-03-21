import java.io.IOException;
import java.util.List;

public class main {
	
	private static final String CHEMIN_FICHIER = "data/scenarios/liste_entreprises/";
	
	public static void executionScenario(String nomFichierEntreprise, String nomFichierBase) throws IOException {
		
		FichierUtils fichEntreprises = new FichierUtils(CHEMIN_FICHIER + nomFichierEntreprise);
		List<String> entreprises = fichEntreprises.getLignes();
		entreprises.remove(0);
		
		ListeBase listeBase = new ListeBase(nomFichierBase);

		// GLOUTON
		System.out.println("==============================");
		System.out.println("=== EXECUTION ALGO GLOUTON ===");
		System.out.println("==============================");

		Glouton glouton = new Glouton(entreprises, listeBase);
		List<Base> basesOpti = glouton.execute();
		int coutTotal = 0;
		System.out.println("Liste des bases necessaire pour obtenir toutes les informations sur les entreprises : ");
		for(Base base : basesOpti) {
			coutTotal += base.getCout();
			System.out.println(base.getNomBase());
		}
		System.out.println("Le cout optimal pour obtenir les informations sur les entreprise est : " + coutTotal);
		
		// BRANCH & BOUND
		System.out.println("==========================");
		System.out.println("=== EXECUTION ALGO B&B ===");
		System.out.println("==========================");
//		BranchAndBound Bb = new BranchAndBound(entreprises);
//		Bb.execute();
		
	}

	public static void main(String[] args) throws IOException{
		
		executionScenario("Liste Ent1.txt","Liste Bases1.txt");
		
	}

}
