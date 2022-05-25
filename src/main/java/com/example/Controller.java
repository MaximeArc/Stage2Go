package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Utilisateur;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class Controller {

    Stage stage;
    Parent root;
    Scene scene;

    static Utilisateur connectedUser;


    /**
     * ACTIONS LORS DU CLIC SUR LE BOUTON "LOGIN"
     * @param actionEvent
     * @throws IOException
     */
    public void OnLoginClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("listeEntreprises.fxml")));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * ACTIONS LORS DU CLIC SUR LE BOUTON "RESSOURCES"
     * @param actionEvent
     * @throws IOException
     */
    public void OnRessourcesClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("listeRessources.fxml")));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * ACTIONS LORS DU CLIC SUR LE BOUTON "ACCUEIL"
     * @param actionEvent
     * @throws IOException
     */
    public void OnAccueilClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("listeEntreprises.fxml")));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * ACTIONS LORS DU CLIC SUR LE BOUTON "STAGIAIRE"
     * @param actionEvent
     * @throws IOException
     */
    public void OnStagiaireClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profilStagiaire.fxml")));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * ACTIONS LORS DU CLIC SUR L'IMAGE "LOGOUT"
     * @param actionEvent
     * @throws IOException
     */
    public void OnExitClick(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quitter");
        alert.setHeaderText("Etes vous sûr de vouloir vous déconnecter ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }


    /**
     * ACTIONS LORS DU CLIC SUR LE BOUTON "LISTE STAGIAIRE"
     * @param actionEvent
     * @throws IOException
     */
    public void OnListeStagiaireClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("listeStagiaires.fxml")));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * ACTIONS LORS DU CLIC SUR LE BOUTON "AJOUTER UN STAGIAIRE"
     * @param actionEvent
     * @throws IOException
     */
    public void OnAjouterStagiaireClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("inscriptionStagiaire.fxml")));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * ACTIONS LORS DU CLIC SUR LE BOUTON "AJOUTER DOCUMENT"
     * @param actionEvent
     */
    public void OnAjouterRessourceClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.showOpenDialog(stage);
    }

    /**
     * ACTIONS LORS DU CLIC SUR LE BOUTON "AJOUTER ENTREPRISE"
     * @param actionEvent
     * @throws IOException
     */
    public void OnAjouterEntrepriseClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("inscriptionEntreprise.fxml")));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * ACTIONS LORS DU CLIC SUR LE BOUTON "FICHE ENTREPRISE"
     * @param actionEvent
     * @throws IOException
     */
    public void OnFicheEntrepriseClick(ActionEvent actionEvent) throws IOException {
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profilEntreprise.fxml")));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * METHODE POUR CACHER UN BOUTON DESTINE AUX ADMIN, QUAND UN NON ADMIN EST CONNECTE
     * @param button
     */
    protected void hideButton(Button button){
        if (!connectedUser.getEst_admin()){
            button.setVisible(false);
        }
    }

}