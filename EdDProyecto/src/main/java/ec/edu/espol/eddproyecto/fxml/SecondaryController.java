package ec.edu.espol.eddproyecto.fxml;

import ec.edu.espol.eddproyecto.clases.ArrayList;
import ec.edu.espol.eddproyecto.clases.Company;
import ec.edu.espol.eddproyecto.clases.Contact;
import ec.edu.espol.eddproyecto.clases.LinkedList;
import ec.edu.espol.eddproyecto.clases.Person;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class SecondaryController {
    
    @FXML
    private Button cancelAddContact;
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
    private CheckBox companyContact;
    @FXML
    private ImageView photoViewer;

    @FXML
    private Button prevPhotoButton;
    @FXML
    private Button nextPhotoButton;
    @FXML
    private Button saveContact;
    
    LinkedList<Contact> contacts = new LinkedList<>();
    
    @FXML
    private void addNewContact() throws IOException {
        Contact newContact;
        if (companyContact.isSelected()){
            String name = getNameFXML.getText();
            String contactNumber = getContactNumberFXML.getText();
            String email = getEmailFXML.getText();
            LinkedList<String> photos = new LinkedList<>();
            photos.addAll(selectedPhotos);
            ArrayList<String> address = new ArrayList<>();
            address.add(getAdressFXML1.getText());
            address.add(getAdressFXML2.getText());
            address.add(getAdressFXML3.getText());
            newContact = new Company(name,contactNumber,email,photos,address);
        } else {
            String name = getNameFXML.getText();
            String lastname = getLastnameFXML.getText();
            String contactNumber = getContactNumberFXML.getText();
            String workNumber = getworkNumberFXML.getText();
            String email = getEmailFXML.getText();
            LinkedList<String> photos = new LinkedList<>();
            photos.addAll(selectedPhotos);
            ArrayList<String> address = new ArrayList<>();
            address.add(getAdressFXML1.getText());
            address.add(getAdressFXML2.getText());
            address.add(getAdressFXML3.getText());
            String workEmail = getworkEmailFXML.getText();
            ArrayList<String> workAddress = new ArrayList<>();
            workAddress.add(getworkAdressFXML1.getText());
            workAddress.add(getworkAdressFXML2.getText());
            workAddress.add(getworkAdressFXML3.getText());
            newContact = new Person(name, lastname,contactNumber,workNumber,email,workEmail,photos,address,workAddress);
        }
        contacts = deserializeLinkedList("src/main/resources/contacts.ser");
        System.out.println("what");
        contacts.add(newContact);
        serializeLinkedList(contacts, "src/main/resources/contacts.ser");

        
        // PrimaryController.showContacts(newContact);
        App.setRoot("primary");

    }
    
    LinkedList<String> selectedPhotos = new LinkedList<>();
    private int indiceActual = 0;

    @FXML
    private void addNewPhoto(ActionEvent event) throws FileNotFoundException {
    FileChooser fileChooser = new FileChooser();

    fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
    fileChooser.setTitle("Seleccionar foto");
    fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Archivos de imagen", "*.png", "*.jpg", "*.gif"),
            new FileChooser.ExtensionFilter("Todos los archivos", "*.*")
    );
    
    Stage stage = (Stage) addPhoto.getScene().getWindow();
    List<File> selectedFiles = fileChooser.showOpenMultipleDialog(stage);

    if (selectedFiles != null && !selectedFiles.isEmpty()) {
        String folderName = getContactNumberFXML.getText();  
        String currentdirectory = System.getProperty("user.dir");
        String objetivefolder = "\\src\\main\\resources\\ec\\edu\\espol\\eddproyecto\\fotos";

        File contactFolder = new File(currentdirectory+objetivefolder, folderName);
        
        if (!contactFolder.exists()) {
            contactFolder.mkdirs();  // Crear la carpeta
        }
        
        for (File file : selectedFiles) {
            String fileName = file.getName();
            File destination = new File(contactFolder, fileName);

            try (InputStream in = new FileInputStream(file);
                 OutputStream out = new FileOutputStream(destination)) {
                // Copiar los bytes de la imagen
                byte[] buffer = new byte[1024];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            String filePath = destination.getAbsolutePath();
            String puntoDeInicio = "\\EdDProyecto";

            int index = filePath.indexOf(puntoDeInicio);
            if (index != -1) {
                String parteRestante = filePath.substring(index + puntoDeInicio.length());
                selectedPhotos.add(System.getProperty("user.dir")+parteRestante);
            } else {
                System.out.println("PHOTO LOAD FAIL!!!");
            }
        }

        startPhotoViewer();
    } else {
        System.out.println("Ningún archivo seleccionado.");  
    }
    startPhotoViewer();
}

    private void startPhotoViewer() throws FileNotFoundException{
        FileInputStream stream = new FileInputStream(selectedPhotos.get(0));
        Image image = new Image(stream);

        photoViewer.setImage(image);
    }
    
    
    private boolean camposDeshabilitados = false;

    @FXML
    private void removeFieldsPerson(ActionEvent event) {
        camposDeshabilitados = !camposDeshabilitados;
        getLastnameFXML.setDisable(camposDeshabilitados);
        getworkNumberFXML.setDisable(camposDeshabilitados);
        getworkEmailFXML.setDisable(camposDeshabilitados);
        getworkAdressFXML1.setDisable(camposDeshabilitados);
        getworkAdressFXML2.setDisable(camposDeshabilitados);
        getworkAdressFXML3.setDisable(camposDeshabilitados);
    }

    @FXML
    private void cancelAddContact(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }
    
    private static void serializeLinkedList(LinkedList<Contact> listContacts, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(listContacts);
            System.out.println("LinkedList serializada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para deserializar una LinkedList
    private static LinkedList<Contact> deserializeLinkedList(String fileName) {
        LinkedList<Contact> deserializedList = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            deserializedList = (LinkedList<Contact>) ois.readObject();
            System.out.println("LinkedList deserializada correctamente.");
            if (deserializedList == null){
                deserializedList = new LinkedList<>();
                return deserializedList;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("vacio");
        }
        return deserializedList;
    }


    @FXML
    private void prevPhotoViewer(ActionEvent event) throws FileNotFoundException {
        int countPhotos = selectedPhotos.size();
        
        if(indiceActual+1 == 0){
            indiceActual = countPhotos-1;
            FileInputStream stream = new FileInputStream(selectedPhotos.get(indiceActual));
            Image image = new Image(stream);

            photoViewer.setImage(image);
        }
        else if(indiceActual+1 > 0){
            indiceActual--;
            FileInputStream stream = new FileInputStream(selectedPhotos.get(indiceActual));
            Image image = new Image(stream);

            photoViewer.setImage(image);
        }
        else{
            
        }

        
    }

    @FXML
    private void nextPhotoViewer(ActionEvent event) throws FileNotFoundException {
        int countPhotos = selectedPhotos.size();
        
        if(indiceActual+1 < countPhotos){
            indiceActual++;
            FileInputStream stream = new FileInputStream(selectedPhotos.get(indiceActual));
            Image image = new Image(stream);
            photoViewer.setImage(image);
        }
        else if(indiceActual+1 >= countPhotos){
            indiceActual = 0;
            FileInputStream stream = new FileInputStream(selectedPhotos.get(indiceActual));
            Image image = new Image(stream);

            photoViewer.setImage(image);
        }
        else{
            
        }
    }
    
}
