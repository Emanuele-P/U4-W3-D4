package ep2024.entities;

import ep2024.enums.Status;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "participations")
public class Participation {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToMany
    @JoinTable(name = "participations_categories",
            joinColumns = @JoinColumn(name = "participation_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "person_id", nullable = false))
    private List<Person> peopleList;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Participation() {
    }

    public Participation(Event event, List<Person> peopleList, Status status) {
        this.event = event;
        this.peopleList = peopleList;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Person> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<Person> peopleList) {
        this.peopleList = peopleList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Participation{" +
                "id=" + id +
                ", event=" + event +
                ", peopleList=" + peopleList +
                ", status=" + status +
                '}';
    }
}
