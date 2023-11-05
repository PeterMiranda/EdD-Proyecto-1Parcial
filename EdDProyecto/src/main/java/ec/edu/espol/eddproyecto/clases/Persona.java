package ec.edu.espol.linkedlist;
import java.util.Comparator;


public class Persona implements Comparator<Persona>{
    
    String nombre;
    String apellido;
    String id; 

    public Persona(String nombre, String apellido, String id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "{" + nombre + ", " + apellido + ", " + id + '}';
    }

    @Override
    public int compare(Persona o1, Persona o2) {
        if (o1.getNombre().equals(o2.getNombre()) && 
            o1.getApellido().equals(o2.getApellido()) && 
            o1.getId().equals(o2.getId())) {
            return 0;
        }
        return -1;
    }
    

}
