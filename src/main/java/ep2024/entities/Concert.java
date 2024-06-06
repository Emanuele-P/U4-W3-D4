package ep2024.entities;

import ep2024.enums.ConcertGenre;
import ep2024.enums.EventType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "concerts")
public class Concert extends Event {
    @Enumerated(EnumType.STRING)
    private ConcertGenre genre;
    private boolean inStreaming;

    public Concert() {
    }

    public Concert(String title, LocalDate date, String description, EventType type, int numOfParticipants, Person.Location location, ConcertGenre genre, boolean inStreaming) {
        super(title, date, description, type, numOfParticipants, location);
        this.genre = genre;
        this.inStreaming = inStreaming;
    }

    public ConcertGenre getGenre() {
        return genre;
    }

    public void setGenre(ConcertGenre genre) {
        this.genre = genre;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "genre=" + genre +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
