module com.example.stage2go {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.stage2go to javafx.fxml;
    exports com.example.stage2go;
}