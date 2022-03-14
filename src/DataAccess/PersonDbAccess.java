package DataAccess;

import Entities.Person;
import com.db4o.ObjectSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDbAccess extends DataAccessLayer {

    public void addPerson(Person args) {
        try {
            this.openConnection();
            this.db.store(args);
        } finally {
            this.closeConnection();
        }

    }

    public void deletePerson(Person args) {
        try {
            this.openConnection();
            this.db.delete(args);
        } finally {
            this.closeConnection();
        }
    }

    public Person[] getPersons() {
        Person[] persons;
        try {
            this.openConnection();
            Person p = new Person();
            ObjectSet<Person> result = this.db.queryByExample(p);
            persons = new Person[result.size()];
            int i = 0;
            while (result.hasNext()) {
                Person newPerson = (Person) result.next();
                persons[i] = newPerson;
                i++;
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            return null;
        } finally {
            this.closeConnection();
        }
        return persons;
    }

    public void updatePerson(Person args) {
        try {
            this.openConnection();
            ObjectSet resultado = this.db.queryByExample(new Person(args.getMatricula()));
            Person obj = (Person) resultado.next();
            obj.setApellido(args.getApellido());
            obj.setNombre(args.getNombre());
            obj.setCarerra(args.getCarerra());
            obj.setEdad(args.getEdad());
            obj.setMatricula(args.getMatricula());
            obj.setDireccion(args.getDireccion());
            this.db.store(obj);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            this.closeConnection();
        }
    }

    public void deletePerons(Person args) {
        try {
            this.openConnection();

            ObjectSet resultado = this.db.queryByExample(new Person(args.getMatricula()));
            Person obj = (Person) resultado.next();
            this.db.delete(obj);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            this.closeConnection();
        }
    }
}
