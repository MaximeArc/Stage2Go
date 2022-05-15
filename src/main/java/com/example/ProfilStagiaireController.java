package com.example;

import dao.UtilisateurDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Utilisateur;

import java.io.IOException;
import java.util.Optional;

public class ProfilStagiaireController extends NavigationController {

    @FXML private TextField nom;
    @FXML private TextField prenom;
    @FXML private TextField mail;
    @FXML private TextField annee;



    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String mailUtilisateur;
    private int anneeUtilisateur;
    private String anneeToString;

    private void viewData(){
        Utilisateur utilisateur = UtilisateurDAO.getInstance().read(1);

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
        viewData();

    }

}