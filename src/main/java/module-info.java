module com.example.stage2go{

    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive java.sql;
    requires transitive javafx.base;

    opens models to javafx.fxml;
    opens com.example.stage2go to javafx.fxml;
    exports com.example.stage2go;
    exports models;
}
