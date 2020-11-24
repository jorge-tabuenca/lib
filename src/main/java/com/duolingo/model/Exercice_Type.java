package com.duolingo.model;

import javax.persistence.*;

@Entity
@Table(name = "Exercice_Type")
public class Exercice_Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private short id;

    @Column(name = "NAME")
    private String name;

    @OneToOne(mappedBy = "exType")
    private Exercice exercice;


    // -----CONSTRUCTORES-----
    public Exercice_Type() {
    }

    public Exercice_Type(String name) {
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

    public Exercice getExercice() {
        return exercice;
    }

    public void setExercice(Exercice exercice) {
        this.exercice = exercice;
    }
}
