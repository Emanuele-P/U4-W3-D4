package ep2024.dao;

import ep2024.entities.Participation;
import ep2024.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class ParticipationDAO {
    private final EntityManager em;

    public ParticipationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Participation participation) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(participation);
        transaction.commit();
        System.out.println("----------The participation: " + participation + " has been saved correctly!");
    }

    public Participation findById(String id) {
        Participation participation = em.find(Participation.class, UUID.fromString(id));
        if (participation == null) throw new NotFoundException(id);
        return new Participation();
    }

    public void deleteById(String id) {
        Participation found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("----------The location with id: " + id + " has been removed correctly!");
    }
}
