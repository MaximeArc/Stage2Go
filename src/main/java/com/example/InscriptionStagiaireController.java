package com.example;

import dao.UtilisateurDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import models.Utilisateur;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static utils.Utils.hashPass;

public class InscriptionStagiaireController extends Controller {

    @FXML private TextField nom;
    @FXML private  TextField prenom;
    @FXML private TextField mail;
    @FXML private PasswordField MotDePasse;
    @FXML private PasswordField ConfirmationMotDePasse;
    @FXML private TextField AnneeDuDiplome;
    @FXML private CheckBox isAdmin;
    @FXML private Text wrongPass;

    /* Déclaration des variables utiles à la création d'un utilisateur
     */
    private String nom1;
    private String prenom1;
    private String mail1;
    private String MotdePasse1;
    private int Annee1;
    private Boolean isAdmin1;


    public void onClickCreate(ActionEvent actionEvent) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        /* Vérifie que les champs indiqués ne sont pas vides
         */
        if(!MotDePasse.getText().equals(ConfirmationMotDePasse.getText())){
            wrongPass.setText("Mots de passe différents");
        }
        if(!nom.getText().isEmpty() && !mail.getText().isEmpty() && !mail.getText().isEmpty() && MotDePasse.getText().equals(ConfirmationMotDePasse.getText())) {
            nom1=nom.getText();
            prenom1=prenom.getText();
            mail1=mail.getText();
            MotdePasse1 = hashPass(MotDePasse.getText());MotDePasse.getText();
            Annee1= Integer.parseInt(AnneeDuDiplome.getText());
            isAdmin1=isAdmin.isSelected();

            Utilisateur stagiaire = new Utilisateur(0 ,nom1,prenom1,mail1,MotdePasse1,0,Annee1,isAdmin1);

            UtilisateurDAO.getInstance().create(stagiaire);
            OnListeStagiaireClick(actionEvent);
        }
    }
}