package com.mycompany.proiekto;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class SecondaryController {

    @FXML
    private Button number1;
    @FXML
    private Button number2;
    @FXML
    private Button number3;
    @FXML
    private Button number4;
    @FXML
    private Button number5;
    @FXML
    private Button number6;
    @FXML
    private Button number7;
    @FXML
    private Button number8;
    @FXML
    private Button number9;
    @FXML
    private Button btnstart;
    
        @FXML
    private GridPane sudokuGrid; // Asegúrate de que esté vinculado correctamente en el FXML

    @FXML
    private void initialize() {
        
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                Label label = new Label();
                label.setText(""); 
                label.setPrefSize(60, 60); 
                label.setStyle("-fx-border-color: black; -fx-alignment: center;"); 
                sudokuGrid.add(label, col, row); 
            }
        }
    }
}