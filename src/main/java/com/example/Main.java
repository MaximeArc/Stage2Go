package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    double x,y = 0;

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("accueilUser.fxml"));
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("listeRessources.fxml")));
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.UNDECORATED);

        root.setOnMousePressed(evt ->{
            x=evt.getSceneX();
            y=evt.getSceneY();
        });

        root.setOnMouseDragged(evt ->{
            stage.setX(evt.getScreenX()- x);
            stage.setY(evt.getScreenY()- y);

        });

        stage.setTitle("Stage2Go");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}