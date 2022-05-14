package com.example;

import dao.EntrepriseDAO;
import dao.UtilisateurDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Entreprise;
import models.Utilisateur;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

public class ListeStagiairesController extends NavigationController {


    @FXML
    private TableView<Utilisateur> table;
    @FXML private TableColumn<Utilisateur, String> nom;
    @FXML private TableColumn<Utilisateur, String> prenom;
    @FXML private TableColumn<Utilisateur, String> mail;
    @FXML private TableColumn<Utilisateur, Date> annee;
    @FXML private TableColumn<Utilisateur, Integer> lieu_stage;


    @FXML private TableView tableView;
    @FXML private Label test;

    private void viewTable(){

        ObservableList<Utilisateur> data = FXCollections.observableArrayList(UtilisateurDAO.getInstance().readAll());
        nom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("prenom"));
        mail.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("email"));
        annee.setCellValueFactory(new PropertyValueFactory<Utilisateur, Date>("annee"));
        lieu_stage.setCellValueFactory(new PropertyValueFactory<Utilisateur,Integer>("lieu_stage"));

        table.setItems((ObservableList<Utilisateur>) data);

    }



    public void initialize(){
        viewTable();

    }


}