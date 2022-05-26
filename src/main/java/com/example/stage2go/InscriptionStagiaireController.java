package com.example.stage2go;


import dao.UtilisateurDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Utilisateur;

import java.io.IOException;

public class InscriptionStagiaireController extends Controller{
    @FXML private TextField nom;
    @FXML private TextField prenom;
    @FXML private TextField mail;
    @FXML private TextField annee;
    @FXML private PasswordField password;



    /* Déclaration des variables utiles à la création d'un nouveau stagiaire
     */
    private String nomStagiaire;
    private String prenomStagiaire;
    private String mailStagiaire;
    private int anneeStagiaire;
    private String passwordStagiaire;



    /*
    Methode se déclenchant au moment du clic sur le bouton "Inscrire un nouveau stagiaire" de la fiche inscriptionStagiaire
    */

    public void onClickCreate(ActionEvent actionEvent){

        //Vérifie que les champs nom, prenom et mail ne sont pas vides
        if(!nom.getText().isEmpty() && !prenom.getText().isEmpty() &&!mail.getText().isEmpty()){

            //Attribue le contenu des champs de texte aux variables déclarées plus haut
            nomStagiaire = nom.getText();
            prenomStagiaire = prenom.getText();
            mailStagiaire = mail.getText();
            anneeStagiaire = Integer.parseInt(annee.getText());
            passwordStagiaire = password.getText();


            //Création d'un nouvel objet entreprise avec les variables en paramètres
            Utilisateur stagiaire = new Utilisateur(nomStagiaire,
                    prenomStagiaire,
                    mailStagiaire,
                    anneeStagiaire,
                    passwordStagiaire);

            //Insertion de cette nouvelle entreprise dans la base de données
            UtilisateurDAO.getInstance().create(stagiaire);
        }
    }
}
