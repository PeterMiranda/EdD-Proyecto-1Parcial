package ec.edu.espol.linkedlist;
import java.util.Comparator;

public class comparatorPersona implements Comparator<Persona>{

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
