/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.eddproyecto.clases;

import java.util.Comparator;

/**
 *
 * @author PC
 */
public interface ContactComparator extends Comparator<Contact> {
    int compareWithSearchString(Contact contact, String searchString);
}
