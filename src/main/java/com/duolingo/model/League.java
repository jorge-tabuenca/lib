package com.duolingo.model;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "League")
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private short id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "league")
    private Set<Ranking> ranking;

    public League() {
    }

    public League(short id, String name, Set<Ranking> ranking) {
        this.id = id;
        this.name = name;
        this.ranking = ranking;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Ranking> getRanking() {
        return ranking;
    }

    public void setRanking(Set<Ranking> ranking) {
        this.ranking = ranking;
    }
}
