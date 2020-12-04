package com.duolingo.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Language_Course")
public class LanguageCourse implements Serializable {
	
	@Id	
	@Column(name = "LANGUAGE_ID")
	private short language_ID;

	@Id	
	@Column(name = "COURSE_ID")
	private short course_ID;
	
	@OneToMany(mappedBy = "language_course_id", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Category> categories;

	public LanguageCourse() {
		
	}
	
	public LanguageCourse(short language_ID, short course_ID) {
		super();
		this.language_ID = language_ID;
		this.course_ID = course_ID;
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

	@Override
	public String toString() {
		return "LanguageCourse [language_ID=" + language_ID + ", course_ID=" + course_ID
				+ ", categories=" + categories + "]";
	}
	
}
