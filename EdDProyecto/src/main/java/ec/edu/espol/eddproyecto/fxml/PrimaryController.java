package ec.edu.espol.eddproyecto.fxml;

import ec.edu.espol.eddproyecto.clases.Person;
import ec.edu.espol.eddproyecto.clases.LinkedList;
import ec.edu.espol.eddproyecto.clases.ArrayList;
import ec.edu.espol.eddproyecto.clases.Contact;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class PrimaryController {
    
    @FXML
    private ListView<Contact> tableView = new ListView<>(); // Especifica el tipo de elementos aquí
    @FXML
    private Button aniadirContacto;
    @FXML
    private TextField searhText;
    @FXML
    private Label setName;
    @FXML
    private ImageView setPhoto;
    @FXML
    private Label setEmail;
    @FXML
    private Label setNumber;
    @FXML
    private Label setAdress;
    @FXML
    private Label setWorkNumber;
    @FXML
    private Label setWorkAdress;
    @FXML
    private Label setWorkEmail;
    @FXML
    private Button deletedButton;
    @FXML
    private HBox workNumberSection;
    @FXML
    private HBox workAddressSection;
    @FXML
    private HBox workEmailSection;
    @FXML
    private Button editButton;
    
    private LinkedList<Contact> contacts = new LinkedList<>();
    private Contact newContact;
    @FXML
    private Button prevPhotoButton;
    @FXML
    private Button nextPhotoButton;

    private void addItemsToListView() {
    /*
    LinkedList<String> photos = new LinkedList<>();
    photos.add("/ec/edu/espol/eddproyecto/fotos/SP.PNG");
    photos.add("/ec/edu/espol/eddproyecto/fotos/Perfil.jpg");
    photos.add("/ec/edu/espol/eddproyecto/fotos/ZzZ.jpg");
        String contactNumber = "+593961443453";
        String workNumber = "+593963931234";
        String email = "jorgeherrerapro2019@gmail.com";
        String workEmail = "joheniet@espol.edu.ec";        ArrayList<String> address = new ArrayList<>();
        address.add("194 Timberline Dr");
        address.add("Brentwood");
        address.add("NY 11717");
        ArrayList<String> workAddress = new ArrayList<>();
        workAddress.add("1777 Fish Camp Rd");
        workAddress.add("Mariposa");
        workAddress.add("CA 93623");
        Person persona1 = new Person("Peter","Miranda",contactNumber, workNumber, email, workEmail, photos, address, workAddress);
        contacts.add(persona1);
        
        LinkedList<String> photos2 = new LinkedList<>();
        photos2.add("/ec/edu/espol/eddproyecto/fotos/moto moto.PNG");
        photos2.add("ec/edu/espol/eddproyecto/fotos/DKSAD.PNG");
        photos2.add("ec/edu/espol/eddproyecto/fotos/DKHORNY.png");
        String contactNumber2 = "+593961443453";
        String workNumber2 = "+593963931234";
        String email2 = "jorgeherrerapro2019@gmail.com";
        String workEmail2 = "joheniet@espol.edu.ec";
        ArrayList<String> address2 = new ArrayList<>();
        address2.add("194 Timberline Dr");
        address2.add("Brentwood");
        address2.add("NY 11717");
        ArrayList<String> workAddress2 = new ArrayList<>();
        workAddress2.add("1777 Fish Camp Rd");
        workAddress2.add("Mariposa");
        workAddress2.add("CA 93623");
        Person persona2 = new Person("Jorge","Herrera",contactNumber2, workNumber2, email2, workEmail2, photos2, address2, workAddress2);
        
        contacts.add(persona2);
        contacts.add(persona1);
        contacts.add(persona2);
        tableView.getItems().addAll(contacts);
    */
        
    }
    
    @FXML
    private void initialize() {
        try{
            contacts = deserializeLinkedList("src/main/resources/contacts.ser");
            tableView.getItems().setAll(contacts);
        }
        catch(NullPointerException npe){
            System.out.println("LISTA VACIA, NADA AGREGADO");
        }
    }
    
    private void initialize(Contact newContact) {
        contacts = deserializeLinkedList("src/main/resources/contacts.ser");
    }
    
    public static void showContacts(Contact contact) throws IOException {
        PrimaryController controller = new PrimaryController();
        controller.initialize(contact);
        App.setRoot("primary");
    }
    
    @FXML
    private void addNewContact(ActionEvent event) throws IOException {
        serializeLinkedList(contacts, "src/main/resources/contacts.ser");
        App.setRoot("secondary");
    }

    private int currentPhotoIndex  = 0;
    private Contact currentSelectedContact = null;
    
    @FXML
    private void selectEmpleado(MouseEvent event) throws FileNotFoundException {
        resetFields();
        Contact contact = tableView.getSelectionModel().getSelectedItem();
        if (contact!=null){
            currentSelectedContact = contact;
            currentPhotoIndex = 0;
            if(contact instanceof Person){
                workNumberSection.setVisible(true);
                workEmailSection.setVisible(true);
                workAddressSection.setVisible(true);
                setName.setText(String.valueOf(contact.getName() +" "+ ((Person)contact).getLastname()));
                setWorkNumber.setText(String.valueOf(((Person)contact).getWorkNumber()));
                setWorkEmail.setText(String.valueOf(((Person)contact).getWorkEmail()));
                setWorkAdress.setText(String.valueOf(((Person)contact).getWorkAddress()));
            }
            else{
                setName.setText(String.valueOf(contact.getName()));
                workNumberSection.setVisible(false);
                workEmailSection.setVisible(false);
                workAddressSection.setVisible(false);
            }
            //ImagenView      
            startPhotoViewer(contact.getPhotos(),currentPhotoIndex);
            
            
            setNumber.setText(String.valueOf(contact.getContactNumber()));
            setEmail.setText(String.valueOf(contact.getEmail()));
            setAdress.setText(String.valueOf(contact.getAddress().toString()));
        }
    }
    
    
    private void startPhotoViewer(LinkedList<String> selectedPhotos, int index) throws FileNotFoundException{
        FileInputStream stream = new FileInputStream(selectedPhotos.get(index));
        Image image = new Image(stream);

        setPhoto.setImage(image);
    }
    
    private void resetFields(){
        setName.setText("");
        setWorkNumber.setText("");
        setWorkEmail.setText("");
        setWorkAdress.setText("");
        setNumber.setText("");
        setEmail.setText("");
        setAdress.setText("");
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
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("vacio");
        }
        return deserializedList;
    }

    @FXML
    private void deleteContact(ActionEvent event) {
        Contact contactToDelete = tableView.getSelectionModel().getSelectedItem();
        
        if (contactToDelete != null) {
            String contactToDeleteNumber = contactToDelete.getContactNumber();
            int i=0;
            for (Contact contact : contacts) {
                if (contact.getContactNumber().equals(contactToDeleteNumber)) {
                    contacts.remove(i); // Elimina el contacto de la lista
                    resetFields();
                    System.out.println("BORRADO CON EXITO");
                    break;
                }
                i++;
            }                 
        }
        tableView.getItems().setAll(contacts);
       
        serializeLinkedList(contacts, "src/main/resources/contacts.ser");
        //contacts = deserializeLinkedList("src/main/resources/contacts.ser");
        //System.out.println("DESPUES DE Desesarilazar "+contacts.toString());
        // Update the TableView
        //tableView.getItems().setAll(contacts);
        //tableView.refresh();  
    }

    @FXML
    private void setPrevPhoto(ActionEvent event) {
        if (currentSelectedContact != null) {
            LinkedList<String> selectedPhotos = currentSelectedContact.getPhotos();

            if (!selectedPhotos.isEmpty()) {
                currentPhotoIndex = (currentPhotoIndex - 1 + selectedPhotos.size()) % selectedPhotos.size();

                try {
                    startPhotoViewer(selectedPhotos, currentPhotoIndex);
                } catch (FileNotFoundException e) {
                    // Manejar la excepción según sea necesario
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    private void setNextPhoto(ActionEvent event) {
        if (currentSelectedContact != null) {
            LinkedList<String> selectedPhotos = currentSelectedContact.getPhotos();

            if (!selectedPhotos.isEmpty()) {
                currentPhotoIndex = (currentPhotoIndex + 1) % selectedPhotos.size();

                try {
                    startPhotoViewer(selectedPhotos, currentPhotoIndex);
                } catch (FileNotFoundException e) {
                        // Manejar la excepción según sea necesario
                        e.printStackTrace();
                }
            }
        }
    }
    
}
