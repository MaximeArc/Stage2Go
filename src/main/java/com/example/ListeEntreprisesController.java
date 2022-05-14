package com.example;

import dao.EntrepriseDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Entreprise;


import java.io.IOException;
import java.util.List;

import static javafx.application.Application.launch;

public class ListeEntreprisesController extends NavigationController {


    @FXML private TableView<Entreprise> table;
    @FXML private TableColumn<Entreprise, String> nom;
    @FXML private TableColumn<Entreprise, String> activites;
    @FXML private TableColumn<Entreprise, String> technos;
    @FXML private TableColumn<Entreprise, String> description;
    @FXML private TableColumn<Entreprise, Integer> nbEmployes;
    @FXML private TableColumn<Entreprise, String> contact;
    @FXML private TableColumn<Entreprise, String> mail;
    @FXML private TableColumn<Entreprise, Boolean> teletravail;


    private void viewTable(){

        ObservableList<Entreprise> data = FXCollections.observableArrayList(EntrepriseDAO.getInstance().readAll());
        nom.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("nom"));
        technos.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("technos"));
        description.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("description"));
        nbEmployes.setCellValueFactory(new PropertyValueFactory<Entreprise, Integer>("nb_employes"));
        contact.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("nom_contact"));
        mail.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("email_contact"));
        teletravail.setCellValueFactory(new PropertyValueFactory<Entreprise, Boolean>("teletravail"));
        activites.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("activites"));

        table.setItems((ObservableList<Entreprise>) data);

    }

    public void initialize(){
        viewTable();
    }

}


