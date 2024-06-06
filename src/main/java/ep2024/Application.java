package ep2024;

import ep2024.dao.EventDAO;
import ep2024.dao.LocationDAO;
import ep2024.dao.ParticipationDAO;
import ep2024.dao.PersonDAO;
import ep2024.entities.Event;
import ep2024.entities.Participation;
import ep2024.entities.Person;
import ep2024.enums.EventType;
import ep2024.enums.Location;
import ep2024.enums.PersonSex;
import ep2024.enums.Status;
import ep2024.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-w3-d3");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventDAO ed = new EventDAO(em);
        LocationDAO ld = new LocationDAO(em);
        PersonDAO pd = new PersonDAO(em);
        ParticipationDAO pad = new ParticipationDAO(em);

        Location location1 = new Location("Hogwarts", "Northumberland");
//        ld.save(location1);

        Event event1 = new Event("Tech Conference", LocalDate.of(2024, 5, 1), "Event on technology", EventType.PUBLIC, 200, location1);
//        ed.save(event1);

        Person person1 = new Person("Morgan", "Freeman", "iamthealmightyone@hv.com", LocalDate.of(1937, 6, 1), PersonSex.M);
        Person person2 = new Person("Jim", "Carrey", "greenface@mask.com", LocalDate.of(1962, 1, 12), PersonSex.M);
//        pd.save(person1);
//        pd.save(person2);

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        Participation participation1 = new Participation(event1, personList, Status.CONFIRMED);
//        pad.save(participation1);

//        Event event2 = new Event("Clown school presentation", LocalDate.of(2024, 6, 30), "The theatrical art of clowns", EventType.PRIVATE, 50);
//
        try {
            Event event1DB = ed.findById("7d217b88-a698-45e1-add3-9272091a840a");
            System.out.println("------------------------------" + event1DB.getDescription());
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
//
//        try {
//            ed.deleteById("");
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }

        em.close();
        emf.close();

    }
}
