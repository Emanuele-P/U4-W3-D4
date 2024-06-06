package ep2024.entities;

import ep2024.enums.PersonSex;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;
    private String mail;
    @Column(name = "year_of_birth")
    private LocalDate yearOfBirth;
    @Enumerated(EnumType.STRING)
    private PersonSex sex;

    @OneToMany(mappedBy = "person")
    private List<Participation> participationList;

    public Person() {
    }

    public Person(String name, String surname, String mail, LocalDate yearOfBirth, PersonSex sex) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.yearOfBirth = yearOfBirth;
        this.sex = sex;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public PersonSex getSex() {
        return sex;
    }

    public void setSex(PersonSex sex) {
        this.sex = sex;
    }

    public LocalDate getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(LocalDate yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public List<Participation> getParticipationList() {
        return participationList;
    }

    public void setParticipationList(List<Participation> participationList) {
        this.participationList = participationList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", sex=" + sex +
                '}';
    }

    @Entity
    @Table(name = "locations")
    public static class Location {
        @Id
        @GeneratedValue
        private UUID id;
        private String name;
        private String city;

        @OneToMany(mappedBy = "location")
        private List<Event> eventList;

        public Location() {
        }

        public Location(String name, String city) {
            this.name = name;
            this.city = city;
        }

        public UUID getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public List<Event> getEventList() {
            return eventList;
        }

        public void setEventList(List<Event> eventList) {
            this.eventList = eventList;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", city='" + city + '\'' +
                    ", eventList=" + eventList +
                    '}';
        }
    }
}
