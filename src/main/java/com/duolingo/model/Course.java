package com.duolingo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EXERCISE_ID")
    private short id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Course_Category",
            joinColumns = { @JoinColumn(name = "Course_ID") },
            inverseJoinColumns = { @JoinColumn(name = "Category_ID") }
    )
    private List<Category> categories;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Actual_Course",
            joinColumns = { @JoinColumn(name = "Course_ID") },
            inverseJoinColumns = { @JoinColumn(name = "User_ID") }
    )
    private List<User> users;


    // -----CONSTRUCTORES-----
    public Course(){
    }

    public Course(String name){
        this.name = name;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
