package com.example;

import dao.EntrepriseDAO;
import dao.CommentaireDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Commentaire;
import models.Entreprise;

import java.io.IOException;
import java.util.Optional;

public class ProfilEntrepriseController extends Controller {

    @FXML
    private TextField nom;
    @FXML
    private TextField activity;
    @FXML
    private TextField techno;
    @FXML
    private TextField nomContact;
    @FXML
    private TextField mailContact;
    @FXML
    private TextField nombreSalarie;
    @FXML
    private TextField adresse;
    @FXML
    private TextField codePostal;
    @FXML
    private TextField ville;
    @FXML
    private CheckBox teletravail;
    @FXML
    private TextArea description;
    @FXML
    private Button modify;
    @FXML
    private Button delete;
    @FXML
    private TableView<Commentaire> table;
    @FXML
    private TableColumn<Commentaire,String> comment;


    private String nomEntreprise;
    private String activiteEntreprise;
    private String technoEntreprise;
    private String nomContactEntreprise;
    private String mailContactEntreprise;
    private String adresseEntreprise;
    private String codePostalEntreprise;
    private String villEntreprise;
    private String descriptionEntreprise;
    private String nbSalarieEntreprise;
    private Boolean teletravailEntreprise;

    private void viewData() {
        Entreprise entreprise = ListeEntrepriseController.selectedEntreprise;
        nomEntreprise = entreprise.getNom();
        activiteEntreprise = entreprise.getActivites();
        nomContactEntreprise = entreprise.getNomContact();
        mailContactEntreprise = entreprise.getEmail_contact();
        nbSalarieEntreprise = String.valueOf(entreprise.getNb_employes());
        descriptionEntreprise = entreprise.getDescription();
        teletravailEntreprise = entreprise.isTeletravail();
        technoEntreprise = entreprise.getTechno();
        /*adresseEntreprise = entreprise.getAdresse().getNumero() + " " + entreprise.getAdresse().getAdresse(); */
       /* codePostalEntreprise = String.valueOf(entreprise.getAdresse().getCode_postal());   */


        nom.setText(nomEntreprise);
        activity.setText(activiteEntreprise);
        mailContact.setText(mailContactEntreprise);
        nomContact.setText((nomContactEntreprise));
        nombreSalarie.setText((nbSalarieEntreprise));
        techno.setText(technoEntreprise);
       /* ville.setText(villEntreprise); */
        description.setText(descriptionEntreprise);
        teletravail.setSelected(teletravailEntreprise);
       /* adresse.setText(adresseEntreprise);
        codePostal.setText((codePostalEntreprise)); */

        teletravail.setStyle("-fx-opacity: 1");

        if (connectedUser.getEst_admin()) {
            nom.setEditable(true);
            activity.setEditable(true);
            mailContact.setEditable(true);
            nomContact.setEditable(true);
            nombreSalarie.setEditable(true);
            techno.setEditable(true);
            adresse.setEditable(true);
            codePostal.setEditable(true);
            teletravail.setDisable(false);

        } else {
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
        entreprise.setActivites((activity.getText()));
        entreprise.setNom_contact(nomContact.getText());
        entreprise.setEmail_contact((mailContact.getText()));
        entreprise.setNb_employes(Integer.parseInt((nombreSalarie.getText())));
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
