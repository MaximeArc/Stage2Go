package com.example;

import dao.UtilisateurDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Utilisateur;
import java.io.IOException;
import java.util.Objects;


public class InscriptionStagiaireController extends Controller {

    @FXML
    private TextField MotDePasse;

    @FXML
    private ImageView logout;

    @FXML
    private Button CreerCompte;

    @FXML
    private TextField mail;

    @FXML
    private TextField ConfirmationMotDePasse;

    @FXML
    private TextField annee;

    @FXML
    void OnClickCreate2(ActionEvent event) {
        String nomSent = nom.getText();
        String prenomSent = prenom.getText();
        String mailSent = mail.getText();
        int anneeSent = Integer.parseInt(annee.getText());
        String motDePasseSent = MotDePasse.getText();
        String confirmationMotDePasseSent = ConfirmationMotDePasse.getText();
        if (isNotEmpty()) {
            if (motDePasseSent.equals(confirmationMotDePasseSent)) {
                Utilisateur newUtilisateur = new Utilisateur(nomSent, prenomSent, mailSent, motDePasseSent, false, anneeSent);
                if (UtilisateurDAO.getInstance().create(newUtilisateur)) {
                    nom.setText("");
                    prenom.setText("");
                    mail.setText("");
                    annee.setText("");
                    MotDePasse.setText("");
                    ConfirmationMotDePasse.setText("");
                }
            }
        }
    }

    private boolean isNotEmpty() {
        boolean isNotEmpty = true;
        if (nom.getText().isEmpty() || prenom.getText().isEmpty() || mail.getText().isEmpty() || annee.getText().isEmpty()
                || MotDePasse.getText().isEmpty() || ConfirmationMotDePasse.getText().isEmpty() ) {
            isNotEmpty = false;
        }
        return isNotEmpty;
    }

//    public Utilisateur(String nom, String prenom, String email, String mot_de_passe, boolean est_admin, int annee) {
//
//        this.nom = nom;
//        this.prenom = prenom;
//        this.email = email;
//        this.mot_de_passe = mot_de_passe;
//        this.est_admin = est_admin;
//        this.annee = annee;
//    }

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField anneeDiplome;

    @FXML
    private Text LABELANNEE;


}
