package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ListeRessourcesController extends Controller {

    @FXML private Button addDoc;


    public void initialize(){

        hideButton(addDoc);
        Test();
    }


    public void Test(){
        String directory = "C:/temp";

        try {
            List<File> files = Files.list(Paths.get(directory))
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .collect(Collectors.toList());

            files.forEach(System.out::println);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }


}


