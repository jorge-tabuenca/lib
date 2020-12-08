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
    
    @Column(name = "NAME")
    private String name;    

    @ManyToOne()
    @JoinColumn (name = "CATEGORY_ID")
    private Category categories;


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

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

}
