package models;


import dao.CommentaireDAO;
import dao.EntrepriseDAO;
import dao.FavoriDAO;

import java.sql.Date;
import java.util.ArrayList;

public class Utilisateur {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String mot_de_passe;
    private boolean est_admin;
    private int lieu_stage;
    private int annee;
    private Entreprise entreprise;
    private Commentaire commentaire;

    private ArrayList<Favori> favoris;


    public Utilisateur(int id, String nom, String prenom, String email, String mdp, int lieu_stage, int annee, boolean isAdmin) {
        this.mot_de_passe=mdp;
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.lieu_stage = lieu_stage;
        this.annee = annee;
        this.est_admin=isAdmin;
    }

    public Utilisateur(int id, String nom, String prenom, String email, String mot_de_passe, boolean est_admin, int annee, int lieu_stage) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.lieu_stage = lieu_stage;
        this.annee = annee;
        this.mot_de_passe = mot_de_passe;
        this.est_admin=est_admin;
        this.id=id;

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

    public String getMot_de_passe() {return mot_de_passe; }
    public void setMot_de_passe(String mot_de_passe) {this.mot_de_passe = mot_de_passe; }

    public boolean isEst_admin() {return est_admin;}
    public void setEst_admin(boolean est_admin) {this.est_admin = est_admin;}

    public int getAnnee() { return annee;}
    public void setAnnee(int annee) {this.annee = annee;}

    public int getLieu_stage() {return lieu_stage;}
    public void setLieu_stage(int lieu_stage) {this.lieu_stage = lieu_stage;}

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public void setCommentaire(Commentaire commentaire) {
        this.commentaire = commentaire;
    }

    public Commentaire getCommentaire() {
        return CommentaireDAO.getCommentByUtilisateur(id);
    }

    public Entreprise getEntreprise() {
        return EntrepriseDAO.getInstance().read(getLieu_stage());
    }


    public ArrayList<Favori> getFavoris() {return FavoriDAO.getInstance().getFavoriByStagiaireId(id);}
    public void setFavoris(ArrayList<Favori> favoris) {this.favoris = favoris;    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", année='" + annee + '\'' +
                ", lieu du stage='" + lieu_stage + '\'' +
                ", mot_de_passe='" + mot_de_passe + '\'' +
                ", est_admin=" + est_admin +

                '}';
    }
}
