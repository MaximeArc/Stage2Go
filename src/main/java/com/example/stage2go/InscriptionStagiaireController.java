package com.example.stage2go;

import dao.Connexion;
import dao.UtilisateurDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import stage2go.Utilisateur;
;import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class InscriptionStagiaireController {
    @FXML private TextField nom;
    @FXML private  TextField prenom;
    @FXML private TextField mail;
    @FXML private TextField filliere;
    @FXML private  TextField MotDePasse;
    @FXML private TextField ConfirmationMotDePasse;
    @FXML private TextField AnneeDuDiplome;
    @FXML private CheckBox isAdmin;

   /* Déclaration des variables utiles à la création d'un utilisateur
    */
    private String nom1;
    private String prenom1;
    private String mail1;
    private String filliere1;
    private String MotdePasse1;
    private String ConfirmationMotDePasse1;
    private String AnneeDuDiplome1;
    private Boolean isAdmin1;

    public void onClickCreate(ActionEvent actionEvent){
        /* Vérifie que les champs indiqués ne sont pas vides
         */
        if(!nom.getText().isEmpty() && !mail.getText().isEmpty() &&!mail.getText().isEmpty()){
            nom1=nom.getText();
            prenom1=prenom.getText();
            mail1=mail.getText();
            filliere1=filliere.getText();
            MotdePasse1=MotDePasse.getText();
            ConfirmationMotDePasse1=ConfirmationMotDePasse.getText();
            AnneeDuDiplome1=AnneeDuDiplome.getText();
            isAdmin1=isAdmin.isSelected();

            Utilisateur stagiaire = new Utilisateur(nom1,prenom1,mail1,MotdePasse1,AnneeDuDiplome1,isAdmin1);

            UtilisateurDAO.getInstance().create(stagiaire);
        }
    }
}
