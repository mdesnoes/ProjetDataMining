import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class regroupant les bases d'une liste sous forme de liste d'objet Base
 *
 * @Kevin
 */
public class ListeBase {
    private int nbBase;
    private String nomFichier;
    private List<Base> listeBases = new ArrayList<>();

    public ListeBase(String fichierListe) throws IOException {
        FichierUtils fichierBases = new FichierUtils("data/scenarios/liste_bases/"+fichierListe);

        List<String> lignes = fichierBases.getLignes();

        this.nbBase = Integer.parseInt(lignes.get(0));

        lignes.stream().filter( ligne -> !Integer.toString(nbBase).equals(ligne))
                .forEach(ligne -> {
                try {
                    creerBase(ligne);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
    }

    /**
     * Permet de creer un objet base en fonction du nom du fichier placé en paramêtre
     * @param fichierBase
     */
    public void creerBase(String fichierBase) throws IOException {
        int cout;
        int nbElement;
        List<String> entreprises = new ArrayList<>();

        FichierUtils utilsBase = new FichierUtils("data/bases/"+fichierBase);

        List<String> lignes = utilsBase.getLignes();

        cout = Integer.parseInt(lignes.get(0));
        nbElement = Integer.parseInt(lignes.get(1));

        lignes.stream().filter( ligne -> !Integer.toString(cout).equals(ligne) ).filter(ligne -> !Integer.toString(nbElement).equals(ligne) )
                .forEach(entreprise -> entreprises.add(entreprise));

        Base base = new Base(cout, nbElement, entreprises);

        this.listeBases.add(base);
    }

    // GETTER ET SETTER DE LA CLASSE
    public int getNbBase() {
        return nbBase;
    }

    public void setNbBase(int nbBase) {
        this.nbBase = nbBase;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public List<Base> getListeBases() {
        return listeBases;
    }

    public void setListeBases(List<Base> listeBases) {
        this.listeBases = listeBases;
    }


}
