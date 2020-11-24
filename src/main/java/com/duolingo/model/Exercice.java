package com.duolingo.model;

import javax.persistence.*;

@Entity
@Table(name = "Exercice")
public class Exercice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private short id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "STATUS")
    private int status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    private Exercice_Type exType;

    @ManyToOne()
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;



    // -----CONSTRUCTORES-----
    public Exercice() {
    }

    public Exercice(String name, int status) {

        this.name = name;
        this.status = status;

    }


    // -----GETTERSnSETTERS-----
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Exercice_Type getExType() {
        return exType;
    }

    public void setExType(Exercice_Type exType) {
        this.exType = exType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
