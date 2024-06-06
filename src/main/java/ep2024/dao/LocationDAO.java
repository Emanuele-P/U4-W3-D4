package ep2024.dao;

import ep2024.entities.Location;
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

    public Location findById(String locationId) {
        Location location = em.find(Location.class, UUID.fromString(locationId));
        if (location == null) throw new NotFoundException(locationId);
        return location;
    }

    public void deleteById(String locationId) {
        Location found = this.findById(locationId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("----------The location with id: " + locationId + " has been removed correctly!");
    }
}
