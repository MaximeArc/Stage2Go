package models;

public class Favori {
    private int id;
    private Utilisateur stagiaire;
    private Entreprise entreprise;
    private String entrepriseNom;


    public Favori(Utilisateur stagiaire, Entreprise entreprise) {

        this.stagiaire=stagiaire;
        this.entreprise=entreprise;
        this.entrepriseNom=entreprise.getNom();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateur getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(Utilisateur stagiaire) {
        this.stagiaire = stagiaire;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public String getEntrepriseNom() {
        return entrepriseNom;
    }

}
