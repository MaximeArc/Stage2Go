package com.example.stage2go;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Utilisateur;

import java.io.IOException;
import java.util.Objects;

public class Controller {

    Stage stage;
    Parent root;
    Scene scene;

    static Utilisateur connectedUser;

    public void OnLoginClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("listeEntreprises.fxml")));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
