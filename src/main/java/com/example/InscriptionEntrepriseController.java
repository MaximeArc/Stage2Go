package com.example;

import dao.EntrepriseDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import models.Entreprise;

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
    Methode se déclenchant au moment du clic sur le bouton Valider de la fiche de creation d'entreprise
    */

    public void onClickCreate(ActionEvent actionEvent) {


        //Vérifie que les champs nom, mail et ville ne sont pas vide (minimum pour identifier une entreprise)
        if(!nom.getText().isEmpty() && !mailContact.getText().isEmpty() && !ville.getText().isEmpty()){


            //Attribue le contenu des champs de texte aux variables déclarées plus haut
            nomEntreprise=nom.getText();
            activiteEntreprise=activite.getText();
            technoEntreprise=techno.getText();
            descriptionEntreprise=description.getText();
            nbEmployesEntreprise=parseInt(nbEmployes.getText());
            nomContactEntreprise=nomContact.getText();
            mailContactEntreprise=mailContact.getText();
            villeEntreprise=ville.getText();
            teletravailEntreprise=teletravail.isSelected();


            //Création d'un nouvel objet entreprise avec les variables en paramètres
            Entreprise entreprise = new Entreprise(nomEntreprise,
                    descriptionEntreprise,
                    activiteEntreprise,
                    technoEntreprise,
                    nbEmployesEntreprise,
                    nomContactEntreprise,
                    mailContactEntreprise,
                    teletravailEntreprise,
                    villeEntreprise);


            //Insertion de cette nouvelle entreprise dans la base de données


            EntrepriseDAO.getInstance().create(entreprise);

        }
    }
}
