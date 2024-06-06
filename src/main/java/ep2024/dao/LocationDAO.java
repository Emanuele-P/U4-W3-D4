package ep2024.dao;

import ep2024.enums.Location;
import ep2024.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("----------The location: " + location + " has been saved correctly!");
    }

    public Location findById(String id) {
        Location location = em.find(Location.class, UUID.fromString(id));
        if (location == null) throw new NotFoundException(id);
        return new Location();
    }

    public void deleteById(String id) {
        Location found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("----------The location with id: " + id + " has been removed correctly!");
    }
}
