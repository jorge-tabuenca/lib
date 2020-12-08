package com.duolingo.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private short id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Actual_Course",
            joinColumns = { @JoinColumn(name = "Course_ID") },
            inverseJoinColumns = { @JoinColumn(name = "User_ID") }
    )
    private Set<User> users;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
    		name = "Language_Course",
    		joinColumns = {@JoinColumn(name = "Course_ID")},
    		inverseJoinColumns = {@JoinColumn(name = "Language_ID")}
    )
    private Set<Language> languages;


    // -----CONSTRUCTORES-----
    public Course(){
    }


	public Course(short id, String name, Set<User> users, Set<Language> languages) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
		this.languages = languages;
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


	public Set<Language> getLanguages() {
		return languages;
	}


	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", users=" + users
				+ ", languages=" + languages + "]";
	}
}
