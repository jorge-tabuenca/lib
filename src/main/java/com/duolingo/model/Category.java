package com.duolingo.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private short id;
    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercice> exercices;

    @ManyToOne()
    @JoinColumn(name = "LEVEL_ID")
    private Level level;

    @ManyToMany(mappedBy = "categories")
    private List<Course> courses;


    // -----CONSTRUCTORES-----
    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }


    // -----GETTERSnSETTERS-----
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public List<Exercice> getExercices() {
        return exercices;
    }

    public void setExercices(List<Exercice> exercices) {
        this.exercices = exercices;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
