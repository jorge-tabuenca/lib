package com.duolingo.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private short id;
    
    @Column(name = "NAME")
    private String name;
    
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumns({
      @JoinColumn(name="Course_ID", referencedColumnName="Course_ID"),
      @JoinColumn(name="Language_ID", referencedColumnName="Language_ID")
    })  
    private LanguageCourse language_course_id; 

    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Level> level;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercice> exercice;
    
    
    // -----CONSTRUCTORES-----
    public Category() {
    }

	public Category(short id, String name, LanguageCourse language_course_id) {
		super();
		this.id = id;
		this.name = name;
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

	public LanguageCourse getLanguage_course_id() {
		return language_course_id;
	}

	public void setLanguage_course_id(LanguageCourse language_course_id) {
		this.language_course_id = language_course_id;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", language_course_id=" + language_course_id + ", level="
				+ level + ", exercice=" + exercice + "]";
	}
}
