module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens models to javafx.fxml;
    opens com.example to javafx.fxml;

    exports com.example;
    exports models;



}