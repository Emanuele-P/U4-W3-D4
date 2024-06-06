package ep2024.entities;

import ep2024.enums.EventType;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class AthleticsCompetition extends Event {
    private Set<Person> athletes = new HashSet<>();

    private Person winner;

    public AthleticsCompetition() {
    }

    public AthleticsCompetition(String title, LocalDate date, String description, EventType type, int numOfParticipants, Person.Location location, Set<Person> athletes, Person winner) {
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
