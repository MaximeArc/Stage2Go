package models;

public class Favori {
    private int id;
    private int id_stagiaire;
    private int id_entreprise;



    private String nom_entreprise;


    public Favori(int id_stagiaire, int id_entreprise, String nom_entreprise) {

        this.id_stagiaire = id_stagiaire;
        this.id_entreprise = id_entreprise;
        this.nom_entreprise=nom_entreprise;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_stagiaire() {
        return id_stagiaire;
    }

    public void setId_stagiaire(int id_stagiaire) {
        this.id_stagiaire = id_stagiaire;
    }

    public int getId_entreprise() {
        return id_entreprise;
    }

    public void setId_entreprise(int id_entreprise) {
        this.id_entreprise = id_entreprise;
    }
    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }

}