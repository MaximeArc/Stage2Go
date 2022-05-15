package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ListeRessourcesController extends Controller {

    @FXML private Button addDoc;


    public void initialize(){
        hideButton(addDoc);
    }
}


