package ec.edu.espol.eddproyecto.fxml;



import ec.edu.espol.eddproyecto.clases.ArrayList;
import ec.edu.espol.eddproyecto.clases.Person;
import ec.edu.espol.eddproyecto.clases.LinkedList;
import ec.edu.espol.eddproyecto.clases.ArrayList;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController {
    
    @FXML
    private ListView<Person> tableView; // Especifica el tipo de elementos aquí
    @FXML
    private Button aniadirContacto;
    @FXML
    private TextField searhText;

    private void addItemsToListView() {
        LinkedList<Person> miLinkedList1 = new LinkedList<>();
        LinkedList<String> photos = new LinkedList<>();
        photos.add("photo 1");
        photos.add("photo 2 ");
        photos.add("photo 3 ");
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
        System.out.println(miLinkedList1.toString());
        //tableView.getItems().add(miLinkedList1.get(i).getName());
        
        LinkedList<String> photos2 = new LinkedList<>();
        photos2.add("photo 1");
        photos2.add("photo 2 ");
        photos2.add("photo 3 ");
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
        
        miLinkedList1.add(persona1);
        miLinkedList1.add(persona2);
        
        tableView.getItems().addAll(miLinkedList1);
    }

    @FXML
    private void initialize() {
        addItemsToListView();
    }

    @FXML
    private void addNewContact(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }
}
