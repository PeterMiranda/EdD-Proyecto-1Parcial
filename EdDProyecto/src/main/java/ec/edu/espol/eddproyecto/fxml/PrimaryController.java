package ec.edu.espol.eddproyecto.fxml;

import ec.edu.espol.eddproyecto.clases.ArrayList;
import ec.edu.espol.eddproyecto.clases.Person;
import ec.edu.espol.eddproyecto.clases.LinkedList;
import ec.edu.espol.eddproyecto.clases.ArrayList;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PrimaryController {
    
    @FXML
    private ListView<Person> tableView; // Especifica el tipo de elementos aquí
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

    private void addItemsToListView() {
        LinkedList<Person> miLinkedList1 = new LinkedList<>();
        LinkedList<String> photos = new LinkedList<>();
        photos.add("/ec/edu/espol/eddproyecto/fotos/SP.PNG");
        photos.add("/ec/edu/espol/eddproyecto/fotos/Perfil.jpg");
        photos.add("/ec/edu/espol/eddproyecto/fotos/ZzZ.jpg");
        String contactNumber = "+593961443453";
        String workNumber = "+593963931234";
        String email = "jorgeherrerapro2019@gmail.com";
        String workEmail = "joheniet@espol.edu.ec";
        ArrayList<String> address = new ArrayList<>();
        address.add("194 Timberline Dr");
        address.add("Brentwood");
        address.add("NY 11717");
        ArrayList<String> workAddress = new ArrayList<>();
        workAddress.add("1777 Fish Camp Rd");
        workAddress.add("Mariposa");
        workAddress.add("CA 93623");
        Person persona1 = new Person("Peter","Miranda",contactNumber, workNumber, email, workEmail, photos, address, workAddress);
        
        miLinkedList1.add(persona1);
        
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
        
        miLinkedList1.add(persona2);
        miLinkedList1.add(persona1);
        
        System.out.println(miLinkedList1.get(0));
        System.out.println(miLinkedList1.get(1));
        
        
        tableView.getItems().setAll(miLinkedList1);
    }

    @FXML
    private void initialize() {
        addItemsToListView();
    }

    @FXML
    private void addNewContact(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void selectEmpleado(MouseEvent event) {
        Person person = tableView.getSelectionModel().getSelectedItem();
        if (person!=null){
            setName.setText(String.valueOf(person.getName() +" "+ person.getLastname()));
            //ImagenView      
            Image image = new Image(getClass().getResourceAsStream(person.getPhotos().get(0)));
            setPhoto.setImage(image);
           //System.out.println(person.getPhotos().get(0));
           setNumber.setText(String.valueOf(person.getContactNumber()));
           setEmail.setText(String.valueOf(person.getEmail()));
           setAdress.setText(String.valueOf(person.getAddress().get(0)));
           setWorkNumber.setText(String.valueOf(person.getWorkNumber()));
           setWorkEmail.setText(String.valueOf(person.getWorkEmail()));
           setWorkEmail.setText(String.valueOf(person.getWorkEmail()));
           setWorkAdress.setText(String.valueOf(person.getAddress().get(1)));
        }
    }
}
