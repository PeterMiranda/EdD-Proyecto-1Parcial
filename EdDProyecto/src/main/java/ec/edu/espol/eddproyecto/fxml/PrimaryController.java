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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

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
    
    private LinkedList<Contact> contacts = new LinkedList<>();
    private Contact newContact;
    @FXML
    private HBox workNumberSection;
    @FXML
    private HBox workAddressSection;
    @FXML
    private HBox workEmailSection;

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
    
    
    @FXML
    private void addNewContact(ActionEvent event) throws IOException {
        serializeLinkedList(contacts, "src/main/resources/contacts.ser");
        App.setRoot("secondary");
    }

    @FXML
    private void selectEmpleado(MouseEvent event) throws FileNotFoundException {
        Contact contact = tableView.getSelectionModel().getSelectedItem();
        if (contact!=null){
            resetFields();
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
            FileInputStream stream = new FileInputStream(contact.getPhotos().get(0));
            Image image = new Image(stream);
        
            setPhoto.setImage(image);
            setNumber.setText(String.valueOf(contact.getContactNumber()));
            setEmail.setText(String.valueOf(contact.getEmail()));
            setAdress.setText(String.valueOf(contact.getAddress().toString()));
        }
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
                    contacts.remove(i);
                    resetFields();
                    System.out.println("BORRADO CON EXITO");
                    break;
                }
                i++;
            }                 
        }
        tableView.getItems().setAll(contacts);
       
        serializeLinkedList(contacts, "src/main/resources/contacts.ser");
    }

    
    

}
