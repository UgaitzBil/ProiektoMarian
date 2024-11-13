package com.mycompany.proiekto;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
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

    private String selectedNumber = ""; // Variable para almacenar el número seleccionado

    private void cargarValoresSudoku() {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("C:\\Users\\2AM3-4\\Documents\\NetBeansProjects\\Proiekto\\src\\main\\java\\modelo\\jsonSudokus.json");
            JsonArray root = JsonParser.parseReader(reader).getAsJsonArray();

            Random random = new Random();
            JsonObject sudokuSeleccionado = root.get(random.nextInt(root.size())).getAsJsonObject();
            JsonArray sudoku = sudokuSeleccionado.getAsJsonArray("sudoku");

            sudokuGrid.getChildren().clear();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int index = i * 9 + j;
                    JsonObject cell = sudoku.get(index).getAsJsonObject();

                    Label label = new Label();
                    label.setPrefSize(60, 60);
                    label.setStyle("-fx-border-color: black; -fx-alignment: center;");

                    if ("V".equals(cell.get("statusCell").getAsString())) {
                        // Si es un valor fijo ("V"), se muestra el valor y no se permite la edición
                        label.setText(cell.get("valueCell").getAsString());
                        label.setStyle(label.getStyle() + "; -fx-background-color: #d3d3d3;"); // Color gris para indicar no editable
                    } else {
                        // Si no es fijo, se permite el cambio de valor
                        label.setOnMouseClicked(e -> {
                            if (!selectedNumber.isEmpty()) {
                                label.setText(selectedNumber);
                            }
                        });
                    }

                    sudokuGrid.add(label, j, i);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error:" + e);
        }
    }

    @FXML
    private void inciarsudoku(ActionEvent event) {
        cargarValoresSudoku();
    }

    @FXML
    private void selectnumero(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        selectedNumber = clickedButton.getText(); // Almacenar el número seleccionado
        System.out.println("Número seleccionado: " + selectedNumber);
    }
}