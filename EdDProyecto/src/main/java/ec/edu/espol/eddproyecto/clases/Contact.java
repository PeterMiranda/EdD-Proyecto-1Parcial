package ec.edu.espol.eddproyecto.clases;

import java.io.Serializable;


public class Contact implements Serializable{
    
    String name;
    String contactNumber;
    String email;
    LinkedList<String> photos;
    ArrayList<String> address;
    


    public Contact(String name, String contactNumber, String email, LinkedList<String> photos, ArrayList<String> address) {
        this.name = name;
        this.contactNumber =  contactNumber;
        this.email =  email;
        this.photos = photos;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LinkedList<String> getPhotos() {
        return photos;
    }

    public void setPhotos(LinkedList<String> photos) {
        this.photos = photos;
    }

    public ArrayList<String> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<String> address) {
        this.address = address;
    }

    
//    @Override
//    public String toString() {
//        return "{" + name + ", " + lastname + ", " + id + '}';
//    }   

}
