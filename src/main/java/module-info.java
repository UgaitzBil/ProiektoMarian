module com.mycompany.proiekto {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.proiekto to javafx.fxml;
    exports com.mycompany.proiekto;
}
