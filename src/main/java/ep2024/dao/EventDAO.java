package ep2024.dao;

import ep2024.entities.Concert;
import ep2024.entities.Event;
import ep2024.entities.FootballMatch;
import ep2024.enums.ConcertGenre;
import ep2024.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class EventDAO {

    private final EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Event event) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(event);
            transaction.commit();
            System.out.println("----------The event: " + event + " has been saved correctly!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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

    public List<Concert> getConcertInStreaming(boolean inStreaming) {
        TypedQuery<Concert> list = em.createNamedQuery("get_concert_in_streaming", Concert.class);
        list.setParameter("inStreaming", inStreaming);
        return list.getResultList();
    }

    public List<Event> getConcertByGenre(ConcertGenre genre) {
        TypedQuery<Event> list = em.createQuery("SELECT e FROM Event e JOIN Concert c ON e.id = c.id WHERE c.genre=:g", Event.class);
        list.setParameter("g", genre);
        return list.getResultList();
    }

    public List<FootballMatch> getMatchesWonAtHome() {
        return em.createNamedQuery("get_matches_won_at_home", FootballMatch.class).getResultList();
    }

    public List<FootballMatch> getMatchesWonAway() {
        return em.createNamedQuery("get_matches_won_away", FootballMatch.class).getResultList();
    }

    public List<FootballMatch> getDrawMatches() {
        return em.createNamedQuery("get_draw_matches", FootballMatch.class).getResultList();
    }
}
