package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RessourcesController {

    Stage stage;
    Parent root;
    Scene scene;


    public void OnRessourcesClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("inscriptionEntreprise.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}


