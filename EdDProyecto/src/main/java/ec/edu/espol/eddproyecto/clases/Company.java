package ec.edu.espol.eddproyecto.clases;

import java.io.Serializable;

public class Company extends Contact implements Serializable{

    public Company(String name, String contactNumber, String email, LinkedList<String> photos, ArrayList<String> address) {
        super(name, contactNumber, email, photos, address);
    }
    
    @Override
    public String toString() {
        return name;
    }
    
}