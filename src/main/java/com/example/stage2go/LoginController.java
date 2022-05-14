package com.example.stage2go;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    Stage stage;
    Parent root;
    Scene scene;

    public void OnStagiaireClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("listeEntreprises.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
