import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FichierUtils {
	
	private String nom;
	private BufferedReader reader;
	
	public FichierUtils(String nom) {
		this.nom = nom;
		
		this.reader = null;
		try {
	    	reader = new BufferedReader(new FileReader(this.nom));
	    } catch(FileNotFoundException exc) {
	    	System.out.println("Erreur d'ouverture");
	    }
	}

	public List<String> getLignes() throws IOException {
	    String ligne;
	    
	    List<String> lignes = new ArrayList<String>();
	    while ((ligne = this.reader.readLine()) != null) {
	    	lignes.add(ligne);
	    }
	    
	    return lignes;
	}
}
