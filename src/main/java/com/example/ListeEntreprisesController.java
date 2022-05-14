package com.example;

import dao.EntrepriseDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.VBox;
import models.Entreprise;


public class ListeEntreprisesController extends NavigationController {


    @FXML private TableView<Entreprise> table;
    @FXML private TableColumn<Entreprise, String> nom;
    @FXML private TableColumn<Entreprise, String> activites;
    @FXML private TableColumn<Entreprise, String> technos;
    //@FXML private TableColumn<Entreprise, String> description;
    //@FXML private TableColumn<Entreprise, Integer> nbEmployes;
    //@FXML private TableColumn<Entreprise, String> contact;
    //@FXML private TableColumn<Entreprise, String> mail;
    //@FXML private TableColumn<Entreprise, Boolean> teletravail;
    @FXML private TableColumn<Entreprise, String> ville;

    @FXML private TableView tableView;
    @FXML private Label test;

    private void viewTable(){

        ObservableList<Entreprise> data = FXCollections.observableArrayList(EntrepriseDAO.getInstance().readAll());
        nom.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("nom"));
        technos.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("techno"));
        //description.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("description"));
        //nbEmployes.setCellValueFactory(new PropertyValueFactory<Entreprise, Integer>("nb_employes"));
        //contact.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("nom_contact"));
        //mail.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("email_contact"));
        //teletravail.setCellValueFactory(new PropertyValueFactory<Entreprise, Boolean>("teletravail"));
        activites.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("activites"));
        ville.setCellValueFactory(new PropertyValueFactory<Entreprise,String>("ville"));


        table.setItems((ObservableList<Entreprise>) data);

    }



    public void initialize(){
        viewTable();

    }


}


