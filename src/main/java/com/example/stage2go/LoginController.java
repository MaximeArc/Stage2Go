package com.example.stage2go;

import javafx.event.ActionEvent;

import dao.UtilisateurDAO;
import models.Utilisateur;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


public class LoginController extends Controller {

   @FXML private TextField identifiant;
   @FXML private PasswordField mdp;

    @Override
    public void OnLoginClick(ActionEvent actionEvent) throws IOException {
        if (!identifiant.getText().isEmpty() && !mdp.getText().isEmpty()){
            Utilisateur utilisateur = UtilisateurDAO.getUserByMail(identifiant.getText());
            connectedUser = utilisateur;
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("listeEntreprises.fxml")));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
