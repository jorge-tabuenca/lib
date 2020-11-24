package com.duolingo.model;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "Level")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private short id;

    @Column(name = "TIER")
    private int tier;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> categories;


    // -----CONSTRUCTORES-----
    public Level() {

    }

    public Level(int tier) {
        this.tier = tier;
    }


    // -----GETTERSnSETTERS-----
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
