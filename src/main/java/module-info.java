module com.mycompany.proiekto {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.proiekto to javafx.fxml;
    requires  com.google.gson;
    exports com.mycompany.proiekto;
}
