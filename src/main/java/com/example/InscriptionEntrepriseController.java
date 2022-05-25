package com.example;

import dao.EntrepriseDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import models.Entreprise;

import java.io.IOException;

import static java.lang.Integer.parseInt;

public class InscriptionEntrepriseController extends Controller {

/*
    Correspond aux fx:id des elements de la vue
*/

    @FXML private TextField nom;
    @FXML private TextField activite;
    @FXML private TextField techno;
    @FXML private TextField description;
    @FXML private TextField nbEmployes;
    @FXML private TextField nomContact;
    @FXML private TextField mailContact;
    @FXML private TextField ville;
    @FXML private CheckBox teletravail;

/*
   Declaration des variables utiles à la creation d'une entreprise
*/

    private String nomEntreprise;
    private String activiteEntreprise;
    private String technoEntreprise;
    private String descriptionEntreprise;
    private int nbEmployesEntreprise;
    private String nomContactEntreprise;
    private String mailContactEntreprise;
    private String villeEntreprise;
    private boolean teletravailEntreprise;

/*
Methode se déclanchant au moment du clic sur le bouton Valider de la fiche de creation d'entreprise
*/

    public void onClickCreate(ActionEvent actionEvent) throws IOException {

/*
        Vérifie que les champs nom, mail et ville ne sont pas vide (minimum pour identifier une entreprise)
*/

        if(!nom.getText().isEmpty() && !mailContact.getText().isEmpty() && !ville.getText().isEmpty()){

/*
            Attribue le contenu des champs de texte aux variables déclarées plus haut
*/

            nomEntreprise=nom.getText();
            activiteEntreprise=activite.getText();
            technoEntreprise=techno.getText();
            descriptionEntreprise=description.getText();
            nbEmployesEntreprise=parseInt(nbEmployes.getText());
            nomContactEntreprise=nomContact.getText();
            mailContactEntreprise=mailContact.getText();
            villeEntreprise=ville.getText();
            teletravailEntreprise=teletravail.isSelected();


/*
            Création d'un nouvel objet entreprise avec les variables en parametres
*/

            Entreprise entreprise = new Entreprise(nomEntreprise,nomContactEntreprise,mailContactEntreprise,nbEmployesEntreprise,descriptionEntreprise,technoEntreprise,teletravailEntreprise,activiteEntreprise,villeEntreprise,0);

/*
            Insertion de cette nouvelle entreprise dans la base de données
*/

            EntrepriseDAO.getInstance().create(entreprise);
            OnAccueilClick(actionEvent);

        }
    }
}
