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
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class InscriptionStagiaireController extends Controller{
    @FXML private TextField nom;
    @FXML private TextField prenom;
    @FXML private TextField mail;
    @FXML private PasswordField password;
    @FXML private CheckBox estAdmin;
    @FXML private TextField annee;




    /* Déclaration des variables utiles à la création d'un nouveau stagiaire
     */
    private String nomStagiaire;
    private String prenomStagiaire;
    private String mailStagiaire;
    private String passwordStagiaire;
    private boolean estAdminStagiaire;
    private int anneeStagiaire;



    /*
    Methode se déclenchant au moment du clic sur le bouton "Inscrire un nouveau stagiaire" de la fiche inscriptionStagiaire
    */

    public void onClickCreate(ActionEvent actionEvent) throws IOException {

        //Vérifie que les champs nom, prenom et mail ne sont pas vides
        if(!nom.getText().isEmpty() && !prenom.getText().isEmpty() &&!mail.getText().isEmpty()){

            //Attribue le contenu des champs de texte aux variables déclarées plus haut
            nomStagiaire = nom.getText();
            prenomStagiaire = prenom.getText();
            mailStagiaire = mail.getText();
            passwordStagiaire = password.getText();
            estAdminStagiaire = estAdmin.isSelected();
            anneeStagiaire = Integer.parseInt(annee.getText());



            //Création d'un nouvel objet utilisateur avec les variables en paramètres
            Utilisateur stagiaire = new Utilisateur(nomStagiaire,
                    prenomStagiaire,
                    mailStagiaire,
                    anneeStagiaire,
                    passwordStagiaire);

            //Insertion de ce nouveau stagiaire dans la base de données
            UtilisateurDAO.getInstance().create(stagiaire);
            OnAccueilClick(actionEvent);
        }
    }
}
