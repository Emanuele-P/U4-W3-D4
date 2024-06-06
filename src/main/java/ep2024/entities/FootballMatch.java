package ep2024.entities;

import ep2024.enums.EventType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "football_matches")
public class FootballMatch extends Event {
    @Column(name = "home_team")
    private String homeTeam;
    @Column(name = "away_team")
    private String awayTeam;
    @Column(name = "winning_team")
    private String winningTeam; // change to null in case of draw
    @Column(name = "home_team_goals")
    private int homeTeamGoals;
    @Column(name = "away_team_goals")
    private int awayTeamGoals;

    public FootballMatch() {
    }

    public FootballMatch(String title, LocalDate date, String description, EventType type, int numOfParticipants,
                         Person.Location location, String homeTeam, String winningTeam, String awayTeam, int homeTeamGoals,
                         int awayTeamGoals) {

        super(title, date, description, type, numOfParticipants, location);
        this.homeTeam = homeTeam;
        this.winningTeam = winningTeam;
        this.awayTeam = awayTeam;
        this.homeTeamGoals = homeTeamGoals;
        this.awayTeamGoals = awayTeamGoals;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(String winningTeam) {
        this.winningTeam = winningTeam;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(int awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    @Override
    public String toString() {
        return "FootballMatch{" +
                "homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", winningTeam='" + winningTeam + '\'' +
                ", homeTeamGoals=" + homeTeamGoals +
                ", awayTeamGoals=" + awayTeamGoals +
                '}';
    }
}
