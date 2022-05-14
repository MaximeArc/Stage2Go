package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class NavigationController {

    Stage stage;
    Parent root;
    Scene scene;


    public void OnRessourcesClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("listeRessources.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void OnAccueilClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("listeEntreprises.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void OnStagiaireClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("profil-stagiaire.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

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

    public void OnListeStagiaireClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("listeStagiaires.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void OnAjouterStagiaireClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("inscriptionStagiaire.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void OnLoginClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("listeEntreprises.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void OnAjouterRessourceClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.showOpenDialog(stage);
    }

    public void OnAjouterEntrepriseClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("inscriptionEntreprise.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void OnFicheEntrepriseClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("profil-entreprise.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

