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

    public Person findById(String id) {
        Person person = em.find(Person.class, UUID.fromString(id));
        if (person == null) throw new NotFoundException(id);
        return person;
    }

    public void deleteById(String id) {
        Person found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("----------The user with id: " + id + " has been removed correctly!");
    }
}
