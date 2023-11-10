package ec.edu.espol.eddproyecto.fxml;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SecondaryController {

    @FXML
    private Button cancelAniadirContacto;
    @FXML
    private Button checkAniadirContacto;
    @FXML
    private TextField setContactName;
    @FXML
    private TextField setContactName1;

    @FXML
    private void cancelAddNewContact(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void checkAddNewContact(ActionEvent event) {
    }
}