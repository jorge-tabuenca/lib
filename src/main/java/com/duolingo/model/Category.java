package com.duolingo.model;

import java.util.Set;

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
    private Set<Exercice> exercices;

    @ManyToOne()
    @JoinColumn(name = "LEVEL_ID")
    private Level level;

    //@ManyToMany(mappedBy = "categories")
    //private Set<Course> courses;    
    
    @ManyToOne()
    @JoinColumn (name = "Language_Course_ID")
    private LanguageCourse language_course_id; 


    // -----CONSTRUCTORES-----
    public Category() {
    }

	public Category(short id, String name, Set<Exercice> exercices, Level level, LanguageCourse language_course_id) {
		super();
		this.id = id;
		this.name = name;
		this.exercices = exercices;
		this.level = level;
		this.language_course_id = language_course_id;
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

	public Set<Exercice> getExercices() {
		return exercices;
	}

	public void setExercices(Set<Exercice> exercices) {
		this.exercices = exercices;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public LanguageCourse getLanguage_course_id() {
		return language_course_id;
	}

	public void setLanguage_course_id(LanguageCourse language_course_id) {
		this.language_course_id = language_course_id;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", exercices=" + exercices + ", level=" + level
				+ ", language_course_id=" + language_course_id + "]";
	}
}
