package com.example;

import javafx.event.ActionEvent;

import dao.UtilisateurDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Utilisateur;

import java.io.IOException;


public class LoginController extends Controller {

    @FXML private TextField login;
    @FXML private PasswordField mdp;


    public void OnLoginClick(ActionEvent actionEvent) throws IOException {
        if(!login.getText().isEmpty() && !mdp.getText().isEmpty()){
           Utilisateur utilisateur = UtilisateurDAO.getUtilisateurByMail(login.getText());
           String password =String.valueOf(mdp.getText());
            if(utilisateur.getMot_de_passe().equals(password)){
                connectedUser= utilisateur;
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("listeEntreprises.fxml"));
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }


        }

    }

    public void initialize(){

    }
}
