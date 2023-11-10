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
public class comparatorLastname implements Comparator<Contact>{
    @Override
    public int compare(Contact o1, Contact o2) {
        if (o1.getLastname().equals(o2.getLastname())) {
            return 0;
        }
        return -1;
    }
}
