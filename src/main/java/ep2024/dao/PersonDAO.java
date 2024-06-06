package ep2024.dao;

import ep2024.entities.Person;
import ep2024.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonDAO {
    private final EntityManager em;

    public PersonDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Person person) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(person);
        transaction.commit();
        System.out.println("----------The user: " + person + " has been saved correctly!");
    }

    public Person findById(String personId) {
        Person person = em.find(Person.class, UUID.fromString(personId));
        if (person == null) throw new NotFoundException(personId);
        return person;
    }

    public void deleteById(String personId) {
        Person found = this.findById(personId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("----------The user with id: " + personId + " has been removed correctly!");
    }
}
