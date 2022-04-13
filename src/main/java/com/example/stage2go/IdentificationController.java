package com.example.stage2go;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class IdentificationController {

    Stage stage;
    Parent root;
    Scene scene;

    @FXML
    private Hyperlink btn1;

    @FXML
    private Text textTest = new Text();


    @FXML
    public void onInscriptionClick(ActionEvent event) throws Exception {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("inscription.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void onValidationClick(ActionEvent event) throws Exception {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("ListeEntreprise.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
    }


}