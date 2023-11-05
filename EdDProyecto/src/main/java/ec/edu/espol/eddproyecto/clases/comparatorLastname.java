/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.eddproyecto.clases;

import java.util.Comparator;

/**
 *
 * @author JorgeHN
 */
public class comparatorLastname implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().equals(o2.getName()) && 
            o1.getLastname().equals(o2.getLastname()) && 
            o1.getId().equals(o2.getId())) {
            return 0;
        }
        return -1;
    }
}
