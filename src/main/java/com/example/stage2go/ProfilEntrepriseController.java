package com.example.stage2go;

import com.example.stage2go.Controller;
import com.example.stage2go.ListeEntrepriseController;
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
import java.util.Optional;


public class ProfilEntrepriseController extends Controller {

    @FXML private TextField nom;
    @FXML private TextField activites;
    @FXML private TextField nomContact;
    @FXML private TextField mailContact;
    @FXML private TextField nbSalaries;
    @FXML private TextField ville;
    @FXML private CheckBox teletravail;
    @FXML private TextArea description;
    @FXML private TextField techno;
    @FXML private TextField adresse;
    @FXML private TextField codePostal;

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

        Entreprise entreprise = ListeEntrepriseController.selectedEntreprise;


        nomEntreprise = entreprise.getNom();
        activiteEntreprise = entreprise.getActivites();
        nomContactEntreprise = entreprise.getNomContact();
        mailContactEntreprise = entreprise.getEmailContact();
        nbSalariesEntreprise = String.valueOf(entreprise.getNb_employes());
        villeEntreprise = entreprise.getVille();
        descritpionEntreprise = entreprise.getDescription();
        teletravailEntreprise = entreprise.isTeletravail();
        technoEntreprise = entreprise.getTechno();
        villeEntreprise = entreprise.getVille();


        nom.setText(nomEntreprise);
        activites.setText(activiteEntreprise);
        mailContact.setText(mailContactEntreprise);
        nomContact.setText(nomContactEntreprise);
        nbSalaries.setText(nbSalariesEntreprise);
        ville.setText(villeEntreprise);
        description.setText(descritpionEntreprise);
        teletravail.setSelected(teletravailEntreprise);
        techno.setText(technoEntreprise);
        ville.setText(villeEntreprise);


        teletravail.setStyle("-fx-opacity: 1");


        if (connectedUser.isEst_admin()) {
            nom.setEditable(true);
            activites.setEditable(true);
            mailContact.setEditable(true);
            nomContact.setEditable(true);
            nbSalaries.setEditable(true);
            ville.setEditable(true);
            description.setEditable(true);
            techno.setEditable(true);
            adresse.setEditable(true);
            codePostal.setEditable(true);

            teletravail.setDisable(false);

        }
        else{
            hideButton(modify);
            hideButton(delete);
        }


    }


    private void viewTable() {

        ObservableList<Commentaire> data = FXCollections.observableArrayList(CommentaireDAO.getComments(ListeEntrepriseController.selectedEntreprise.getId()));
        comment.setCellValueFactory(new PropertyValueFactory<Commentaire, String>("contenu"));
        table.setItems((ObservableList<Commentaire>) data);
        table.setSelectionModel(null);

    }


    public void initialize() {
        viewData();
        viewTable();

    }


    public void onClickUpdate(ActionEvent actionEvent) throws IOException {
        Entreprise entreprise = ListeEntrepriseController.selectedEntreprise;
        entreprise.setNom(nom.getText());
        entreprise.setTechno(techno.getText());
        entreprise.setNomContact(nomContact.getText());
        entreprise.setEmailContact(mailContact.getText());
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
            Entreprise entreprise = ListeEntrepriseController.selectedEntreprise;
            EntrepriseDAO.getInstance().delete(entreprise);
            OnAccueilClick(actionEvent);
        }

    }

}