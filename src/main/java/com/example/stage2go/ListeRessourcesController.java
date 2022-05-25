package com.example.stage2go;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;


public class ListeRessourcesController extends Controller{

    @FXML private Button addDoc;


    public void initialize(){

        hideButton(addDoc);
    }

}