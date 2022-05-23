package com.example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Utilisateur;
import java.io.IOException;
import java.util.Optional;


/*
Controller principal qui regroupe les methodes utiles dans toute l'application
*/

public class Controller {

    Stage stage;
    Parent root;
    Scene scene;

    static Utilisateur connectedUser ;  /* <--- Utilisateur gardé enregistré a la connexion et accessible pour toute l'application*/

/*
    Action lors du clic sur le bouton Ressources
*/

    public void OnRessourcesClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("listeRessources.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

/*
    Action lors du clic sur le bouton Entreprises
*/

    public void OnAccueilClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("listeEntreprises.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

/*
    Action lors du clic sur le bouton Stagiaire
*/

    public void OnStagiaireClick(ActionEvent actionEvent) throws IOException {

        if(connectedUser.isEst_admin()){
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("listeStagiairesAdmin.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("profil-stagiaire.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

/*
    Action lors du clic sur le bouton/image Exit
*/

    public void OnExitClick(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quitter");
        alert.setHeaderText("Etes vous sur de vouloir vous déconnecter ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

/*
    Action lors du clic sur le bouton Liste Stagiaire
*/

    public void OnListeStagiaireClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("listeStagiairesAdmin.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

/*
    Action lors du clic sur le bouton Ajouter Stagiaire
*/

    public void OnAjouterStagiaireClick(ActionEvent actionEvent) throws IOException {



        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("inscriptionStagiaire.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

/*
    Action lors du clic sur le bouton Ajouter Document
*/

    public void OnAjouterRessourceClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Ajouter document");
        fileChooser.showOpenDialog(stage);
    }


/*
    Action lors du clic sur le bouton Ajouter Entreprise
*/

    public void OnAjouterEntrepriseClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("inscriptionEntreprise.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

/*
    Action lors du clic sur le bouton Fiche Entreprise
*/


/*
    Methode qui cache les boutons admin quand un non-admin est connecté
*/

    void hideButton(Button button){
        if (!connectedUser.isEst_admin()){
            button.setVisible(false);
        }
    }




}

