package com.mycompany.proiekto;



import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
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
        cargarValoresSudoku();
    }

    private void cargarValoresSudoku() {
        try {
            // Leer el archivo JSON
            Gson gson = new Gson();
            FileReader reader = new FileReader("C:\\Users\\2AM3-9\\Documents\\NetBeansProjects\\ProiektoMarian\\src\\main\\java\\modelo\\jsonSudokus.json"); // Cambia la ruta al archivo
               
            System.out.println("commit de prueba aitor");
            // Parsear el archivo JSON y obtener el array de Sudokus
            JsonArray root = JsonParser.parseReader(reader).getAsJsonArray();
            
            // Seleccionar un Sudoku aleatorio (índice entre 0 y 2)
            Random random = new Random();
            JsonObject sudokuSeleccionado = root.get(random.nextInt(root.size())).getAsJsonObject();
            JsonArray sudoku = sudokuSeleccionado.getAsJsonArray("sudoku");

            // Limpiar el GridPane antes de cargar el nuevo Sudoku
            sudokuGrid.getChildren().clear();

            // Mostrar las celdas del Sudoku en el GridPane
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int index = i * 9 + j;
                    JsonObject cell = sudoku.get(index).getAsJsonObject();

                    // Crear el Label para cada celda
                    Label label = new Label();
                    label.setPrefSize(60, 60);
                    label.setStyle("-fx-border-color: black; -fx-alignment: center;");

                    // Asignar valor solo si statusCell es "V"
                    if ("V".equals(cell.get("statusCell").getAsString())) {
                        label.setText(cell.get("valueCell").getAsString());
                    }

                    // Añadir el Label al GridPane
                    sudokuGrid.add(label, j, i);
                }
            }
            
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void nigger () {
        for (int i = 0; i < 5; i++) {
            System.out.println("otra prueba mas");
        }
    }
}