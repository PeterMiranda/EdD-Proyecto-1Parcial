package ec.edu.espol.eddproyecto.clases;
import java.util.Comparator;

public class comparatorPerson implements Comparator<Person>{
    
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().equals(o2.getName()) && 
            o1.getLastname().equals(o2.getLastname())) {
            return 0;
        }
        return -1;
    }
    
}
