package com.example;

import dao.EntrepriseDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Entreprise;

import java.io.IOException;


public class ListeEntreprisesController extends Controller {

    static Entreprise selectedEntreprise;

    @FXML private TableView<Entreprise> table;
    @FXML private TableColumn<Entreprise, String> nom;
    @FXML private TableColumn<Entreprise, String> activites;
    @FXML private TableColumn<Entreprise, String> technos;
    @FXML private TableColumn<Entreprise, String> ville;
    @FXML private Button addBtn;


    private void viewTable(){

        ObservableList<Entreprise> data = FXCollections.observableArrayList(EntrepriseDAO.getInstance().readAll());
        nom.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("nom"));
        technos.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("techno"));
        activites.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("activites"));
        ville.setCellValueFactory(new PropertyValueFactory<Entreprise,String>("ville"));

        table.setItems((ObservableList<Entreprise>) data);
    }

    public void selectFromTable(MouseEvent event) throws IOException {

         selectedEntreprise = table.getSelectionModel().getSelectedItem();
         System.out.println(table.getSelectionModel().getSelectedItem());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("profil-entreprise.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




    public void initialize(){
        viewTable();
        hideButton(addBtn);

    }





}


