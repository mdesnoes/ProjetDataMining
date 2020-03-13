import java.io.IOException;
import java.util.List;

public class main {

	public static void main(String[] args) throws IOException{

		FichierUtils fichEntreprises = new FichierUtils("data/scenarios/liste_entreprises/Liste Ent1.txt");
		
		List<String> entreprises = fichEntreprises.getLignes();
		entreprises.forEach(entreprise ->
			System.out.println(entreprise)
		);
		
	}

}
