package ec.edu.espol.eddproyecto.fxml;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class SecondaryController {

    @FXML
    private Button cancelAddContact;
    @FXML
    private Button addContact;
    @FXML
    private TextField getNameFXML;
    @FXML
    private TextField getContactNumberFXML;
    @FXML
    private TextField getLastnameFXML;
    @FXML
    private TextField getEmailFXML;
    @FXML
    private TextField getAdressFXML;
    @FXML
    private TextField getworkNumberFXML;
    @FXML
    private TextField getworkEmailFXML;
    @FXML
    private TextField getworkAdressFXML;

    @FXML
    private void addNewContact(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }
    
}