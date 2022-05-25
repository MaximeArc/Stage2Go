package com.example;

import dao.EntrepriseDAO;
import dao.FavoriDAO;
import dao.UtilisateurDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import models.*;

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

    @FXML private TableView<Commentaire> table;
    @FXML private TableColumn<Commentaire, String> comment;

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


    private void viewData(){

            Entreprise entreprise = ListeEntreprisesController.selectedEntreprise;
            Adresse adresseE = EntrepriseDAO.getInstance().getAdress(entreprise.getId());


            nomEntreprise=entreprise.getNom();
            activiteEntreprise=entreprise.getActivites();
            nomContactEntreprise=entreprise.getNomContact();
            mailContactEntreprise=entreprise.getEmail_contact();
            nbSalariesEntreprise=String.valueOf(entreprise.getNb_employes());
            villeEntreprise=entreprise.getVille();
            descritpionEntreprise=entreprise.getDescription();
            teletravailEntreprise=entreprise.isTeletravail();
            technoEntreprise=entreprise.getTechno();
            adresseEntreprise= adresseE.getNumero() + " " + adresseE.getAdresse();
            codePostalEntreprise=String.valueOf(adresseE.getCode_postal());


            nom.setText(nomEntreprise);
            activite.setText(activiteEntreprise);
            mailContact.setText(mailContactEntreprise);
            nomContact.setText(nomContactEntreprise);
            activite.setText(activiteEntreprise);
            nbSalaries.setText(nbSalariesEntreprise);
            ville.setText(villeEntreprise);
            description.setText(descritpionEntreprise);
            teletravail.setSelected(teletravailEntreprise);
            techno.setText(technoEntreprise);
            adresse.setText(adresseEntreprise);
            codePostal.setText(codePostalEntreprise);

            teletravail.setStyle("-fx-opacity: 1");


    }


    private void viewTable(){

        ObservableList<Commentaire> data = FXCollections.observableArrayList(EntrepriseDAO.getInstance().getComments(ListeEntreprisesController.selectedEntreprise.getId()));
        comment.setCellValueFactory(new PropertyValueFactory<Commentaire, String>("contenu"));
        table.setItems((ObservableList<Commentaire>) data);
        table.setSelectionModel(null);

    }


    public void initialize(){
        viewData();
        viewTable();

    }

}
