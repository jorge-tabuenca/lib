package com.duolingo.model;

import javax.persistence.*;

@Entity
@Table(name = "Ranking")
public class Ranking {

    @Id
    @Column(name = "POSITION")
    private int position;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LEAGUE_ID", nullable = false)
    private League league;

    public Ranking() {
    }

    public Ranking(int position, User user, League league) {
        this.position = position;
        this.user = user;
        this.league = league;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
