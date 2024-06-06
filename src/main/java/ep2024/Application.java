package ep2024;

import com.github.javafaker.Faker;
import ep2024.dao.EventDAO;
import ep2024.dao.LocationDAO;
import ep2024.dao.ParticipationDAO;
import ep2024.dao.PersonDAO;
import ep2024.entities.*;
import ep2024.enums.ConcertGenre;
import ep2024.enums.EventType;
import ep2024.enums.PersonSex;
import ep2024.enums.Status;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        Location location1 = new Location("Hogwarts", "Northumberland");
        Location location2 = new Location(faker.address().city(), faker.address().cityName());
//        ld.save(location);

        Event event1 = new Event("Clown school presentation", LocalDate.of(2024, 6, 30), "The theatrical art of clowns", EventType.PRIVATE, 50, location1);
        Event event2 = new Event("Tech Conference", LocalDate.of(2024, 5, 1), "Event on technology", EventType.PUBLIC, 200, location1);
//        ed.save(event1);

        Person person1 = new Person("Morgan", "Freeman", "iamthealmightyone@hv.com", LocalDate.of(1937, 6, 1), PersonSex.M);
        Person person2 = new Person(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), LocalDate.of(1957, 3, 2), random.nextInt(0, 2) == 0 ? PersonSex.M : PersonSex.F);
//        pd.save(person);

        Participation participation = new Participation(event1, person1, Status.CONFIRMED);
//        pad.save(participation);

        Location matchLocation = ld.findById("6d1afb4c-c937-4314-9c17-eab47e55869d");
        FootballMatch m1 = new FootballMatch("Champions League", LocalDate.of(2024, 7, 12), "Finals", EventType.PUBLIC, 80000, matchLocation, "Juve", "Inter");
//        ed.save(m1);

        Location concertLocation = ld.findById("42bf00f1-8c35-4445-9aae-5b7ef54de90f");
        Concert c1 = new Concert("Concert", LocalDate.now(), "concert example", EventType.PUBLIC, 30000, concertLocation, ConcertGenre.POP, false);


        Person athlete1 = pd.findById("8f4b3723-4697-4035-bad4-0703ef064c42");
        Person athlete2 = pd.findById("a767579d-0c4c-40bf-8c9c-877b81100bdb");
        Person athlete3 = pd.findById("b6927549-2e51-4291-8284-4c8dd047a3d6");
        Person winner = new Person("Peter", "Parker", faker.internet().emailAddress(), LocalDate.of(1980, 3, 7), PersonSex.M);
        Set<Person> athletes = Stream.of(athlete1, athlete2, athlete3, winner).collect(Collectors.toSet());
        Location atLocation = ld.findById("036a3a6e-a117-4f1c-91db-aa2038c16743");

        AthleticsCompetition competition = new AthleticsCompetition("100m Sprint", LocalDate.of(2024, 7, 18), "Finals, Female", EventType.PUBLIC, 1000, atLocation, athletes, winner);
        try {
            ed.save(competition);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while committing the transaction: " + e.getMessage());
        }

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
