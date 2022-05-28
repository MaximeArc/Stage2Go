package com.example;

import dao.EntrepriseDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Entreprise;

import java.io.IOException;
import java.util.Objects;

public class ListeEntrepriseController extends Controller {
    static Entreprise selectedEntreprise;
    @FXML private TableColumn<Entreprise, String> ville;
    @FXML private TableView<Entreprise> table;
    @FXML private TableColumn<Entreprise, String> nom;
    @FXML private TableColumn<Entreprise, String> activites;
    @FXML private TableColumn<Entreprise, String> techno;

    @FXML private Button addBtn;


    private void viewTable(){

        ObservableList<Entreprise> data = FXCollections.observableArrayList(EntrepriseDAO.getInstance().readAll());
        nom.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("nom"));
        techno.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("techno"));
        activites.setCellValueFactory(new PropertyValueFactory<Entreprise, String>("activites"));
        ville.setCellValueFactory(new PropertyValueFactory<Entreprise,String>("ville"));

        table.setItems(data);

    }

    public void selectFromTable(MouseEvent event) throws IOException, IOException {

        selectedEntreprise = table.getSelectionModel().getSelectedItem();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profilEntreprise.fxml")));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void initialize(){
        viewTable();
        hideButton(addBtn);

    }


}