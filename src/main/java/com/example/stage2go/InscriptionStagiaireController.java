package com.example.stage2go;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

    public class InscriptionStagiaireController {


        Stage stage;
        Parent root;
        Scene scene;


        public void OnRessourcesClick(ActionEvent actionEvent) throws IOException {
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("listeRessources.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        public void OnAccueilClick(ActionEvent actionEvent) throws IOException {
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("listeEntreprises.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

        public void OnStagiaireClick(ActionEvent actionEvent) throws IOException {
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("profilStagiaire.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        public void OnExitClick(ActionEvent actionEvent) throws IOException {
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

