package com.duolingo.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private short id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch =  FetchType.EAGER, mappedBy = "language")
    private Set<User> users;

    public Language() {
    }

    public Language(short id, String name, Set<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
