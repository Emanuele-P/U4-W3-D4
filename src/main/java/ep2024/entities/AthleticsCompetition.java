package ep2024.entities;

import ep2024.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "athletics_competitions")
public class AthleticsCompetition extends Event {
    @ManyToMany
    @JoinTable(
            name = "competition_athletes",
            joinColumns = @JoinColumn(name = "competition_id"),
            inverseJoinColumns = @JoinColumn(name = "athlete_id")
    )
    private Set<Person> athletes;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Person winner;

    public AthleticsCompetition() {
    }

    public AthleticsCompetition(String title, LocalDate date, String description, EventType type, int numOfParticipants, Location location, Set<Person> athletes, Person winner) {
        super(title, date, description, type, numOfParticipants, location);
        this.athletes = athletes;
        this.winner = winner;
    }

    public Set<Person> getAthletes() {
        return athletes;
    }

    public void setAthletes(Set<Person> athletes) {
        this.athletes = athletes;
    }

    public Person getWinner() {
        return winner;
    }

    public void setWinner(Person winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "AthleticsCompetition{" +
                "athletes=" + athletes +
                ", winner=" + winner +
                '}';
    }
}
