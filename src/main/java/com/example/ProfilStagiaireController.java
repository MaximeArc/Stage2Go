package com.example;

import dao.EntrepriseDAO;
import dao.FavoriDAO;
import dao.UtilisateurDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Entreprise;
import models.Favori;
import models.Utilisateur;

public class ProfilStagiaireController extends Controller {

    @FXML private TextField nom;
    @FXML private TextField prenom;
    @FXML private TextField mail;
    @FXML private TextField annee;
    @FXML private TextField entreprise;
    @FXML private TextArea comment;

    @FXML private Button addStagiaire;
    @FXML private Button listeStagiaire;

    @FXML private TableView<Favori> table;
    @FXML private TableColumn<Favori, String> nom_entreprise;





    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String mailUtilisateur;
    private int anneeUtilisateur;
    private String anneeToString;

    private void viewData(){
        Utilisateur utilisateur = UtilisateurDAO.getInstance().read(connectedUser.getId());
        String lieu_stage = UtilisateurDAO.getInstance().getLieuStageByUtilisateurId(connectedUser.getId());
        String commentaire = UtilisateurDAO.getInstance().getCommentByUtilisateurId(connectedUser.getId());


        nomUtilisateur=utilisateur.getNom();
        prenomUtilisateur=utilisateur.getPrenom();
        mailUtilisateur=utilisateur.getEmail();
        anneeUtilisateur=utilisateur.getAnnee();

        anneeToString=String.valueOf(anneeUtilisateur);

        nom.setText(nomUtilisateur);
        prenom.setText(prenomUtilisateur);
        mail.setText(mailUtilisateur);
        annee.setText(anneeToString);
        entreprise.setText(lieu_stage);
        comment.setText(commentaire);



    }

    private void viewTable(){

        ObservableList<Favori> data = FXCollections.observableArrayList(FavoriDAO.getInstance().getFavoriByStagiaireId(connectedUser.getId()));
        nom_entreprise.setCellValueFactory(new PropertyValueFactory<Favori, String>("nom_entreprise"));
        table.setItems((ObservableList<Favori>) data);
    }

    public void initialize(){
        hideButton(listeStagiaire);
        hideButton(addStagiaire);
        viewData();
        viewTable();

    }

}