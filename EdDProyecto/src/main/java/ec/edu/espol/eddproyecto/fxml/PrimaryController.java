package ec.edu.espol.eddproyecto.fxml;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController {
    
    @FXML
    private ListView<String> tableView; // Especifica el tipo de elementos aquí
    @FXML
    private TextField searchText;


    private void addItemsToListView() {
        // Aquí puedes agregar elementos a tu ListView
        tableView.getItems().addAll("Elemento 1", "Elemento 2", "Elemento 3");
    }


    // Método de inicialización de controlador de FXML
    @FXML
    private void initialize() {
        addItemsToListView();
    }
}
