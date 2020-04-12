import java.io.IOException;
import java.util.List;

public class main {
	
	private static final String CHEMIN_FICHIER = "data/scenarios/liste_entreprises/";
	
	public static void executionScenario(String nomFichierEntreprise, String nomFichierBase) throws IOException {
		
		// Initialisation des variables pour l'algo glouton
		FichierUtils fichEntreprises = new FichierUtils(CHEMIN_FICHIER + nomFichierEntreprise);
		List<String> entreprises = fichEntreprises.getLignes();
		entreprises.remove(0);
		ListeBase listeBase = new ListeBase(nomFichierBase);

		// GLOUTON
		System.out.println("==============================");
		System.out.println("=== EXECUTION ALGO GLOUTON ===");
		System.out.println("==============================");

		Glouton glouton = new Glouton(entreprises, listeBase);
		long timeDebut = System.currentTimeMillis();
		glouton.execute();
		long timeFin = System.currentTimeMillis();
	    System.out.println("### Temps d'execution : "+ (timeFin - timeDebut) + " milliseconde(s) ###\n");
		
		// Ré-initialisation des variables pour executer le deuxième algo ( B&B )
		fichEntreprises = new FichierUtils(CHEMIN_FICHIER + nomFichierEntreprise);
		entreprises = fichEntreprises.getLignes();
		entreprises.remove(0);
		listeBase = new ListeBase(nomFichierBase);
		
		// BRANCH & BOUND
		System.out.println("==========================");
		System.out.println("=== EXECUTION ALGO B&B ===");
		System.out.println("==========================");
    
		BranchAndBound bb = new BranchAndBound(entreprises,listeBase);
		timeDebut = System.currentTimeMillis();
		bb.execute();
		timeFin = System.currentTimeMillis();
		System.out.println("### Temps d'exécution : " + (timeFin - timeDebut) + " milliseconde(s) ###\n");
	}

	
	public static void main(String[] args) throws IOException{
		
		System.out.println("------ Scenario 1 -------");
		executionScenario("Liste Ent1.txt","Liste Bases1.txt");
		System.out.println();
		System.out.println();
		System.out.println("------ Scenario 2 -------");
		executionScenario("Liste Ent2.txt","Liste Bases2.txt");
		System.out.println();
		System.out.println();
		System.out.println("------ Scenario 3 -------");
		executionScenario("Liste Ent3.txt","Liste Bases3.txt");
		System.out.println();
		System.out.println("------ Scenario 4 -------");
		executionScenario("Liste Ent4.txt","Liste Bases4.txt");
		
	}

}
