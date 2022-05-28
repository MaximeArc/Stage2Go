package com.example;

import dao.CommentaireDAO;
import dao.EntrepriseDAO;
import dao.FavoriDAO;
import dao.UtilisateurDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProfilEntrepriseController extends Controller {

    @FXML private TextField nom;
    @FXML private TextField activite;
    @FXML private TextField nomContact;
    @FXML private TextField mailContact;
    @FXML private TextField nbSalaries;
    @FXML private TextField ville;
    @FXML private CheckBox teletravail;
    @FXML private TextArea description;
    @FXML private TextField techno;
    @FXML private TextField adresse;
    @FXML private TextField codePostal;
    @FXML private CheckBox favori;

    @FXML private TableView<Commentaire> table;
    @FXML private TableColumn<Commentaire, String> comment;

    @FXML private Button modify;
    @FXML private Button delete;


    private String nomEntreprise;
    private String activiteEntreprise;
    private String nomContactEntreprise;
    private String mailContactEntreprise;
    private String nbSalariesEntreprise;
    private String villeEntreprise;
    private String descritpionEntreprise;
    private Boolean teletravailEntreprise;
    private String technoEntreprise;
    private String adresseEntreprise;
    private String codePostalEntreprise;


    private void viewData() {

        Entreprise entreprise = ListeEntreprisesController.selectedEntreprise;


        nomEntreprise = entreprise.getNom();
        activiteEntreprise = entreprise.getActivites();
        nomContactEntreprise = entreprise.getNomContact();
        mailContactEntreprise = entreprise.getEmail_contact();
        nbSalariesEntreprise = String.valueOf(entreprise.getNb_employes());
        villeEntreprise = entreprise.getAdresse().getVille();
        descritpionEntreprise = entreprise.getDescription();
        teletravailEntreprise = entreprise.isTeletravail();
        technoEntreprise = entreprise.getTechno();
        adresseEntreprise = entreprise.getAdresse().getNumero() + " " + entreprise.getAdresse().getAdresse();
        codePostalEntreprise = String.valueOf(entreprise.getAdresse().getCode_postal());


        nom.setText(nomEntreprise);
        activite.setText(activiteEntreprise);
        mailContact.setText(mailContactEntreprise);
        nomContact.setText(nomContactEntreprise);
        nbSalaries.setText(nbSalariesEntreprise);
        ville.setText(villeEntreprise);
        description.setText(descritpionEntreprise);
        teletravail.setSelected(teletravailEntreprise);
        techno.setText(technoEntreprise);
        adresse.setText(adresseEntreprise);
        codePostal.setText(codePostalEntreprise);

        teletravail.setStyle("-fx-opacity: 1");

        if (connectedUser.isEst_admin()) {
            nom.setEditable(true);
            activite.setEditable(true);
            mailContact.setEditable(true);
            nomContact.setEditable(true);
            nbSalaries.setEditable(true);
            ville.setEditable(true);
            description.setEditable(true);
            techno.setEditable(true);
            adresse.setEditable(true);
            codePostal.setEditable(true);

            teletravail.setDisable(false);
            favori.setVisible(false);

        }
        else
        {
            hideButton(modify);
            hideButton(delete);


            for (Favori fav:connectedUser.getFavoris()) {
                if(fav.getEntreprise().getId()==ListeEntreprisesController.selectedEntreprise.getId())
                {
                    favori.setSelected(true);
                }
            }
            }


        }





    private void viewTable() {

        ObservableList<Commentaire> data = FXCollections.observableArrayList(CommentaireDAO.getComments(ListeEntreprisesController.selectedEntreprise.getId()));
        comment.setCellValueFactory(new PropertyValueFactory<Commentaire, String>("contenu"));
        table.setItems((ObservableList<Commentaire>) data);
        table.setSelectionModel(null);
    }


    public void initialize() {
        viewData();
        viewTable();
    }


    public void onClickUpdate(ActionEvent actionEvent) throws IOException {
        Entreprise entreprise = ListeEntreprisesController.selectedEntreprise;
        entreprise.setNom(nom.getText());
        entreprise.setTechno(techno.getText());
        entreprise.setActivites(activite.getText());
        entreprise.setNomContact(nomContact.getText());
        entreprise.setEmail_contact(mailContact.getText());
        entreprise.setNb_employes(Integer.parseInt(nbSalaries.getText()));
        entreprise.setDescription(description.getText());
        entreprise.setTeletravail(teletravail.isSelected());

        EntrepriseDAO.getInstance().update(entreprise);
        OnAccueilClick(actionEvent);
    }


    public void onClickDelete(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Supprimer");
        alert.setHeaderText("Etes vous sur de vouloir supprimer cette fiche entreprise ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Entreprise entreprise = ListeEntreprisesController.selectedEntreprise;
            EntrepriseDAO.getInstance().delete(entreprise);
            OnAccueilClick(actionEvent);
        }

    }

    public void onClickFavori(ActionEvent actionEvent) {


        if (favori.isSelected()) {
            ArrayList<Favori> listFavoris = connectedUser.getFavoris();
            Favori favori = new Favori(connectedUser, ListeEntreprisesController.selectedEntreprise);
            listFavoris.add(favori);
            connectedUser.setFavoris(listFavoris);
            FavoriDAO.getInstance().create(favori);
        } else {
            ArrayList<Favori> listFavoris = connectedUser.getFavoris();
            for (Favori fav : listFavoris) {
                if (fav.getEntreprise().getId() == ListeEntreprisesController.selectedEntreprise.getId() && fav.getStagiaire().getId() == connectedUser.getId()) {
                    listFavoris.remove(fav);
                    connectedUser.setFavoris(listFavoris);
                    FavoriDAO.getInstance().delete(fav);
                }

            }
        }
    }
}