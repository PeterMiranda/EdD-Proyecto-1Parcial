package ec.edu.espol.eddproyecto.clases;


public class Contact{
    
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
   
//    @Override
//    public String toString() {
//        return "{" + name + ", " + lastname + ", " + id + '}';
//    }    

}
