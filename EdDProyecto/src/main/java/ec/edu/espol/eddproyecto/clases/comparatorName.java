/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.eddproyecto.clases;

/**
 *
 * @author JorgeHN
 */
public class comparatorName implements ContactComparator{
    
    @Override
    public int compare(Contact o1, Contact o2) {
        if (o1.getName().equals(o2.getName())) {
            return 0;
        }
        return -1;
    }
    
    @Override
    public int compareWithSearchString(Contact contact, String searchString) {
        return contact.getName().toLowerCase().startsWith(searchString.toLowerCase()) ? 0 : -1;
    }
    
 }
