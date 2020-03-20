import java.util.ArrayList;

public class Noeud {
	private int cout;
	private ArrayList<String> entreprises;
	private ArrayList<Base> bases;
	
	
	public Noeud(ArrayList<String> entreprises, int cout, ArrayList<Base> bases) {
		super();
		this.entreprises = entreprises;
		this.cout = cout;
		this.bases = bases;
	}	
}
