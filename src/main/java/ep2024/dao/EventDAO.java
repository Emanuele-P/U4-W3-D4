package ep2024.dao;

import ep2024.entities.Event;
import ep2024.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class EventDAO {

    private final EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Event event) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event);
        transaction.commit();
        System.out.println("----------The event: " + event + " has been saved correctly!");
    }

    public Event findById(String eventId) {
        Event event = em.find(Event.class, UUID.fromString(eventId));
        if (event == null) throw new NotFoundException(eventId);
        return event;
    }

    public void deleteById(String eventId) {
        Event found = this.findById(eventId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("----------The event with id: " + eventId + " has been removed correctly!");
    }
}
