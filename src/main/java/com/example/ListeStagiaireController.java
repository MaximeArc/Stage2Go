package com.example;

import dao.UtilisateurDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Utilisateur;


public class ListeStagiaireController extends Controller {

    @FXML private TableView<Utilisateur> table;
    @FXML private TableColumn<Utilisateur, String> nom;
    @FXML private TableColumn<Utilisateur, String> prenom;
    @FXML private TableColumn<Utilisateur, String> mail;
    @FXML private TableColumn<Utilisateur, Integer> annee;

    private void viewTable(){

        ObservableList<Utilisateur> data = FXCollections.observableArrayList(UtilisateurDAO.getInstance().readAll());
        nom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("prenom"));
        mail.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("email"));
        annee.setCellValueFactory(new PropertyValueFactory<Utilisateur, Integer>("annee"));

        table.setItems((ObservableList<Utilisateur>) data);

    }

    public void initialize(){
        viewTable();

    }
}