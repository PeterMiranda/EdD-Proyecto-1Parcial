/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.eddproyecto.clases;

/**
 *
 * @author JorgeHN
 */
public class Person extends Contact{
    
    String lastname;
    String workNumber;
    String workEmail;
    ArrayList<String> workAddress;
    
    public Person(String name, String lastname, String contactNumber, String workNumber, String email, String workEmail, LinkedList<String> photos, ArrayList<String> address, ArrayList<String> workAddress) {
        super(name, contactNumber, email, photos, address);
        this.lastname =  lastname;
        this.workNumber = workNumber;
        this.workEmail = workEmail;
        this.workAddress = workAddress;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public ArrayList<String> getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(ArrayList<String> workAddress) {
        this.workAddress = workAddress;
    }

    /*
    @Override
    public String toString() {
        return "Person{" + "name=" + name + "lastname=" + lastname + ", workNumber=" + workNumber + ", contactNumber=" + contactNumber + ", email=" + email + ", workEmail=" + workEmail + ", photos=" + photos.toString() + ", address=" + address.toString() + ", workAddress=" + workAddress.toString() + '}';
    }
    */
    
    @Override
    public String toString() {
        return name + " " + lastname;
    }
    
}
