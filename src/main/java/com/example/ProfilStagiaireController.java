package com.example;

import dao.UtilisateurDAO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Utilisateur;

public class ProfilStagiaireController extends Controller {

    @FXML private TextField nom;
    @FXML private TextField prenom;
    @FXML private TextField mail;
    @FXML private TextField annee;
    @FXML private Button addStagiaire;
    @FXML private Button listeStagiaire;




    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String mailUtilisateur;
    private int anneeUtilisateur;
    private String anneeToString;

    private void viewData(){
        Utilisateur utilisateur = UtilisateurDAO.getInstance().read(connectedUser.getId());

        nomUtilisateur=utilisateur.getNom();
        prenomUtilisateur=utilisateur.getPrenom();
        mailUtilisateur=utilisateur.getEmail();
        anneeUtilisateur=utilisateur.getAnnee();

        anneeToString=String.valueOf(anneeUtilisateur);

        nom.setText(nomUtilisateur);
        prenom.setText(prenomUtilisateur);
        mail.setText(mailUtilisateur);
        annee.setText(anneeToString);
    }

    public void initialize(){
        hideButton(listeStagiaire);
        hideButton(addStagiaire);
        viewData();

    }

}