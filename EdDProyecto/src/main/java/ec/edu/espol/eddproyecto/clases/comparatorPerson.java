package ec.edu.espol.eddproyecto.clases;
import java.util.Comparator;

public class comparatorPerson implements Comparator<Contact>{
    
    @Override
    public int compare(Contact o1, Contact o2) {
        if (o1.getName().equals(o2.getName()) && 
            o1.getLastname().equals(o2.getLastname()) && 
            o1.getId().equals(o2.getId())) {
            return 0;
        }
        return -1;
    }
    
}
