package com.example;

import dao.EntrepriseDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Entreprise;

public class ListeEntrepriseController extends Controller {

    @FXML private TableView<Entreprise> table;
    @FXML private TableColumn<Entreprise, String> nom;
    @FXML private TableColumn<Entreprise, String> activites;
    @FXML private TableColumn<Entreprise, String> techno;
    @FXML private TableColumn<Entreprise, String> ville;
    @FXML private Button addBtn;


    private void viewTable(){

        ObservableList<Entreprise> data = FXCollections.observableArrayList(EntrepriseDAO.getInstance().readAll());
        nom.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("nom"));
        techno.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("techno"));
        activites.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("activites"));
        ville.setCellValueFactory(new PropertyValueFactory<Entreprise,String>("ville"));

        table.setItems(data);

    }


    public void initialize(){
        viewTable();
        hideButton(addBtn);

    }


}