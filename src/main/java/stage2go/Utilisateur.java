package stage2go;


import javafx.scene.control.TextField;

import java.sql.Date;

public class Utilisateur {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String num_tel;
    private String mot_de_passe;
    private boolean est_admin;

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    private String annee;

    public Utilisateur( String nom, String prenom,  String email,
                       String mot_de_passe,String annee, boolean est_admin) {

        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mot_de_passe = mot_de_passe;
        this.est_admin = est_admin;
        this.annee = annee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public boolean isEst_admin() {
        return est_admin;
    }

    public void setEst_admin(boolean est_admin) {
        this.est_admin = est_admin;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", num_tel='" + num_tel + '\'' +
                ", mot_de_passe='" + mot_de_passe + '\'' +
                ", est_admin=" + est_admin +
                '}';
    }

    public String getAnneeDiplome() {
        //TODO
        return getAnneeDiplome();
    }
}
