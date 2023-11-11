package ec.edu.espol.eddproyecto.fxml;

import ec.edu.espol.eddproyecto.clases.ArrayList;
import ec.edu.espol.eddproyecto.clases.Person;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

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
    private TextField getworkNumberFXML;
    @FXML
    private TextField getworkEmailFXML;
    @FXML
    private TextField getAdressFXML1;
    @FXML
    private TextField getworkAdressFXML1;
    @FXML
    private TextField getAdressFXML3;
    @FXML
    private TextField getworkAdressFXML2;
    @FXML
    private TextField getworkAdressFXML3;
    @FXML
    private TextField getAdressFXML2;
    @FXML
    private Button addPhoto;

    @FXML
    private void addNewContact(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }
    
    private void addNewContact() {
        String name = getNameFXML.getText();
        String lastName = getLastnameFXML.getText();
        String contactNumber = getContactNumberFXML.getText();
        String workNumber = getworkNumberFXML.getText();
        String email = getEmailFXML.getText();
        ArrayList<String> address = new ArrayList<>();
        address.add(getAdressFXML1.getText());
        address.add(getAdressFXML2.getText());
        address.add(getAdressFXML3.getText());
        String workEmail = getworkEmailFXML.getText();
        ArrayList<String> workAddress = new ArrayList<>();
        address.add(getworkAdressFXML1.getText());
        address.add(getworkAdressFXML2.getText());
        address.add(getworkAdressFXML3.getText());
        
        
        
        
        //Person newPersona = new Person(name,lastName, contactNumber, workNumber, email, workEmail, photos, address, workAddress);
        
    }

    @FXML
    private void addNewPhoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar foto");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de imagen", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Todos los archivos", "*.*")
        );

        Stage stage = (Stage) addPhoto.getScene().getWindow();
        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(stage);

        if (selectedFiles != null) {
            for (File file : selectedFiles) {
                System.out.println("Archivo seleccionado: " + file.getAbsolutePath());
                // Puedes almacenar la ruta del archivo o procesarlo de alguna otra manera
            }
        } else {
            System.out.println("Ningún archivo seleccionado.");
        }
    }
    
}