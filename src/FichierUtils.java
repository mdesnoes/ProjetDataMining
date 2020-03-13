import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FichierUtils {
	
	private String nom;
	
	public FichierUtils(String nom) {
		this.nom = nom;
	}

	public List<String> getContenu() throws IOException {
		BufferedReader reader = null;
	    String ligne;
	    
	    List<String> lignes = new ArrayList<String>();

	    try {
	    	reader = new BufferedReader(new FileReader(this.nom));
	    } catch(FileNotFoundException exc) {
	    	System.out.println("Erreur d'ouverture");
	    }
	    
	    while ((ligne = reader.readLine()) != null) {
	    	lignes.add(ligne);
	    }
	    
	    reader.close();
	    return lignes;
	}
}
