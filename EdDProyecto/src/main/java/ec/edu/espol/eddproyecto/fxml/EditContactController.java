/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.eddproyecto.fxml;

import ec.edu.espol.eddproyecto.clases.ArrayList;
import ec.edu.espol.eddproyecto.clases.Company;
import ec.edu.espol.eddproyecto.clases.Contact;
import ec.edu.espol.eddproyecto.clases.LinkedList;
import ec.edu.espol.eddproyecto.clases.Person;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author JorgeHN
 */
public class EditContactController implements Initializable {

    @FXML
    private Button cancelAddContact;
    @FXML
    private ImageView photoViewer;
    @FXML
    private Button saveContact;
    @FXML
    private TextField getNameFXML;
    @FXML
    private TextField getContactNumberFXML;
    @FXML
    private TextField getEmailFXML;
    @FXML
    private TextField getAdressFXML;
    @FXML
    private TextField getAdressFXML2;
    @FXML
    private TextField getAdressFXML3;
    @FXML
    private TextField getWorkAdressFXML;
    @FXML
    private TextField getWorkAdressFXML2;
    @FXML
    private TextField getWorkAdressFXML3;
    @FXML
    private TextField getWorkNumberFXML;
    @FXML
    private TextField getWorkEmailFXML;
    @FXML
    private TextField getLastnameFXML; 
    
    private Contact contactToEdit;
    private LinkedList<Contact> contacts;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private void initialize(Contact contact) throws FileNotFoundException {
//        if (contact!=null){
//            if(contact instanceof Person){
//                try{
//                getWorkAdressFXML.setDisable(false);
//                getWorkAdressFXML2.setDisable(false);
//                getWorkAdressFXML3.setDisable(false);
//                getWorkNumberFXML.setDisable(false);
//                getWorkEmailFXML.setDisable(false);
//                }
//                catch(NullPointerException npe){
//                    System.out.println("kk");
//                }
//                getNameFXML.setText(String.valueOf(contact.getName() +" "+ ((Person)contact).getLastname()));
//                getWorkNumberFXML.setText(String.valueOf(((Person)contact).getWorkNumber()));
//                getWorkEmailFXML.setText(String.valueOf(((Person)contact).getWorkEmail()));
//                getWorkAdressFXML.setText(String.valueOf(((Person)contact).getWorkAddress()));
//            }
//            else{
//                try{
//                getWorkAdressFXML.setDisable(true);
//                getWorkAdressFXML2.setDisable(true);
//                getWorkAdressFXML3.setDisable(true);
//                getWorkNumberFXML.setDisable(true);
//                getWorkEmailFXML.setDisable(true);
//                }
//                catch(NullPointerException npe){
//                    System.out.println("kk");
//                }
//
//                getNameFXML.setText(String.valueOf(contact.getName()));
//
//            }
//            //ImagenView      
//            FileInputStream stream = new FileInputStream(contact.getPhotos().get(0));
//            Image image = new Image(stream);
//        
//            photoViewer.setImage(image);
//            getContactNumberFXML.setText(String.valueOf(contact.getContactNumber()));
//            getEmailFXML.setText(String.valueOf(contact.getEmail()));
//            getAdressFXML.setText(String.valueOf(contact.getAddress().toString()));
//        }
    }
    
    public void showEditContact(Contact contact, LinkedList<Contact> contacts) throws FileNotFoundException {
        initialize(contact);
        contactToEdit = contact;
        this.contacts = contacts;
    }
    
    @FXML
    private void saveContact(ActionEvent event) throws IOException {
        contactToEdit.setName(getNameFXML.getText());
        contactToEdit.setContactNumber(getContactNumberFXML.getText());
        contactToEdit.setEmail(getEmailFXML.getText());
        ArrayList<String> address = new ArrayList<>();
        address.add(getAdressFXML.getText());
        address.add(getAdressFXML2.getText());
        address.add(getAdressFXML3.getText());
        contactToEdit.setAddress(address);
//            LinkedList<String> photos = new LinkedList<>();
//            photos.addAll(selectedPhotos);

        if (contactToEdit instanceof Person){
            ((Person)contactToEdit).setLastname(getLastnameFXML.getText());
            ((Person)contactToEdit).setWorkNumber(getWorkNumberFXML.getText());
            ((Person)contactToEdit).setWorkEmail(getWorkEmailFXML.getText());
            ArrayList<String> workAddress = new ArrayList<>();
            workAddress.add(getWorkAdressFXML.getText());
            workAddress.add(getWorkAdressFXML2.getText());
            workAddress.add(getWorkAdressFXML3.getText());
            ((Person)contactToEdit).setWorkAddress(workAddress);
        }
        System.out.println(contacts);
        serializeLinkedList(contacts, "src/main/resources/contacts.ser");
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
}
