package ep2024;

import com.github.javafaker.Faker;
import ep2024.dao.EventDAO;
import ep2024.dao.LocationDAO;
import ep2024.dao.ParticipationDAO;
import ep2024.dao.PersonDAO;
import ep2024.entities.Event;
import ep2024.entities.Participation;
import ep2024.entities.Person;
import ep2024.enums.EventType;
import ep2024.enums.PersonSex;
import ep2024.enums.Status;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Random;

public class Application {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-w3-d4");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventDAO ed = new EventDAO(em);
        LocationDAO ld = new LocationDAO(em);
        PersonDAO pd = new PersonDAO(em);
        ParticipationDAO pad = new ParticipationDAO(em);
        Faker faker = new Faker();
        Random random = new Random();

        Person.Location location1 = new Person.Location("Hogwarts", "Northumberland");
        Person.Location location2 = new Person.Location(faker.address().city(), faker.address().cityName());
//        ld.save(location1);
//        ld.save(location2);

        Event event1 = new Event("Clown school presentation", LocalDate.of(2024, 6, 30), "The theatrical art of clowns", EventType.PRIVATE, 50, location1);
        Event event2 = new Event("Tech Conference", LocalDate.of(2024, 5, 1), "Event on technology", EventType.PUBLIC, 200, location1);
//        ed.save(event1);
//        ed.save(event2);

        Person person1 = new Person("Morgan", "Freeman", "iamthealmightyone@hv.com", LocalDate.of(1937, 6, 1), PersonSex.M);
        Person person2 = new Person(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), LocalDate.of(1957, 3, 2), random.nextInt(0, 2) == 0 ? PersonSex.M : PersonSex.F);
//        pd.save(person1);
//        pd.save(person2);

        Participation participation = new Participation(event1, person1, Status.CONFIRMED);
//        pad.save(participation);

//        try {
//            Person personDB = pd.findById("59485f9c-4d14-43c8-8e6f-16c737163b6c");
//            Event eventDB = ed.findById("2837e8b4-fb71-429a-b91b-53f160647c7f");
//            System.out.println("------------------------------" + eventDB.getDescription());
//            System.out.println("------------------------------" + personDB.getSurname());
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }

//        try {
//            ed.deleteById("");
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }

        em.close();
        emf.close();

    }
}
