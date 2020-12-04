package com.duolingo.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Language_Course")
public class LanguageCourse implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "ID")
	private short id;
	
	@Column(name = "LANGUAGE_ID")
	private short language_ID;

	@Column(name = "COURSE_ID")
	private short course_ID;
	
	 @OneToMany(mappedBy = "language_course_id", cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<Category> categories;

	public LanguageCourse() {
		
	}

	public LanguageCourse(short id, short language_ID, short course_ID, List<Category> categories) {
		super();
		this.id = id;
		this.language_ID = language_ID;
		this.course_ID = course_ID;
		this.categories = categories;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public short getLanguage_ID() {
		return language_ID;
	}

	public void setLanguage_ID(short language_ID) {
		this.language_ID = language_ID;
	}

	public short getCourse_ID() {
		return course_ID;
	}

	public void setCourse_ID(short course_ID) {
		this.course_ID = course_ID;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "LanguageCourse [id=" + id + ", language_ID=" + language_ID + ", course_ID=" + course_ID
				+ ", categories=" + categories + "]";
	}
}
