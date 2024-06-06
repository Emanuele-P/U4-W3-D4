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

    public Participation findById(String participationId) {
        Participation participation = em.find(Participation.class, UUID.fromString(participationId));
        if (participation == null) throw new NotFoundException(participationId);
        return participation;
    }

    public void deleteById(String participationId) {
        Participation found = this.findById(participationId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("----------The location with id: " + participationId + " has been removed correctly!");
    }
}
