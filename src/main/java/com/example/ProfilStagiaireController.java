package com.example;

import dao.EntrepriseDAO;
import dao.FavoriDAO;
import dao.UtilisateurDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Entreprise;
import models.Favori;
import models.Utilisateur;

import java.io.IOException;
import java.util.ArrayList;

public class ProfilStagiaireController extends Controller {

    static Favori selectedFavori;

    @FXML private TextField nom;
    @FXML private TextField prenom;
    @FXML private TextField mail;
    @FXML private TextField annee;
    @FXML private TextField entreprise;
    @FXML private TextArea comment;
    @FXML private ChoiceBox listDeroulante;

    @FXML private Button modify;
    @FXML private Button delete;

    @FXML private TableView<Favori> table;
    @FXML private TableColumn<Favori, String> nom_entreprise;



    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String mailUtilisateur;
    private int anneeUtilisateur;
    private String anneeToString;

    private void viewData(){

        if (!connectedUser.isEst_admin()){

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
            comment.setWrapText(true);

            hideButton(modify);
            hideButton(delete);
            listDeroulante.setVisible(false);
        }

        else{

            Utilisateur stagiaire = ListeStagiairesAdminController.selectedIntern;

            String lieu_stage = stagiaire.getEntreprise().getNom();
            String commentaire = stagiaire.getCommentaire().getContenu();


            nomUtilisateur=stagiaire.getNom();
            prenomUtilisateur=stagiaire.getPrenom();
            mailUtilisateur=stagiaire.getEmail();
            anneeUtilisateur=stagiaire.getAnnee();

            anneeToString=String.valueOf(anneeUtilisateur);

            nom.setText(nomUtilisateur);
            prenom.setText(prenomUtilisateur);
            mail.setText(mailUtilisateur);
            annee.setText(anneeToString);
            entreprise.setText(lieu_stage);
            comment.setText(commentaire);

            comment.setWrapText(true);

            entreprise.setVisible(false);
        }

    }

    private void viewTable(){

        if(!connectedUser.isEst_admin()){
            ObservableList<Favori> favoris = FXCollections.observableArrayList(connectedUser.getFavoris());
            table.setItems(favoris);
        }
        else{
            ObservableList<Favori> data = FXCollections.observableArrayList(FavoriDAO.getInstance().getFavoriByStagiaireId(ListeStagiairesAdminController.selectedIntern.getId()));
            table.setItems(data);
        }


        nom_entreprise.setCellValueFactory(new PropertyValueFactory<Favori, String>("entrepriseNom"));


    }

    public void initialize(){
        viewData();
        viewTable();
        liste();

    }

    public void selectFromTable(MouseEvent event) throws IOException {

        selectedFavori = table.getSelectionModel().getSelectedItem();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("profil-entreprise.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onClickUpdate(ActionEvent actionEvent) throws IOException {

    }


    public void onClickDelete(ActionEvent actionEvent) throws IOException {

    }


    public void selectFromTableFavori(MouseEvent event) throws IOException {

        Favori favori = table.getSelectionModel().getSelectedItem();
        ListeEntreprisesController.selectedEntreprise=favori.getEntreprise();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("profil-entreprise.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void liste(){
        ObservableList<Entreprise> entreprises = FXCollections.observableArrayList(EntrepriseDAO.getInstance().readAll());
        ArrayList<String> nomEntreprise = new ArrayList<>();

        for (Entreprise entreprise:entreprises) {
            String name=entreprise.getNom();
            nomEntreprise.add(name);
            listDeroulante.setItems(FXCollections.observableArrayList(nomEntreprise));

        }
        }


    }
