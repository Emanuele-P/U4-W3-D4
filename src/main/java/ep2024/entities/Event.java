package ep2024.entities;

import ep2024.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "events")
@Inheritance(strategy = InheritanceType.JOINED)
public class Event {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private LocalDate date;
    private String description;
    @Column(name = "event_type")
    @Enumerated(EnumType.STRING)
    private EventType type;
    @Column(name = "max_number_of_participants")
    private int numOfParticipants;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Person.Location location;

    @OneToMany(mappedBy = "event")
    private List<Participation> participationList;

    public Event() {
    }

    public Event(String title, LocalDate date, String description, EventType type, int numOfParticipants, Person.Location location) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.type = type;
        this.numOfParticipants = numOfParticipants;
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public int getNumOfParticipants() {
        return numOfParticipants;
    }

    public void setNumOfParticipants(int numOfParticipants) {
        this.numOfParticipants = numOfParticipants;
    }

    public Person.Location getLocation() {
        return location;
    }

    public void setLocation(Person.Location location) {
        this.location = location;
    }

    public List<Participation> getParticipationList() {
        return participationList;
    }

    public void setParticipationList(List<Participation> participationList) {
        this.participationList = participationList;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", numOfParticipants=" + numOfParticipants +
                ", location=" + location +
                ", participation=" + participationList +
                '}';
    }
}
