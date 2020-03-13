import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException{

		FichierUtils fichier = new FichierUtils("data/Base 1.txt");
		
		fichier.getContenu().forEach(ligne -> 
			System.out.println(ligne)
		);		
	}

}
