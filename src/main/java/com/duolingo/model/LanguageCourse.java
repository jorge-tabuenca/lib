package com.duolingo.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Language_Course")
public class LanguageCourse {
	
	@Id
	@Column(name = "LANGUAGE_ID")
	private int language_ID;
	
	@Column(name = "COURSE_ID")
	private int course_ID;

	public LanguageCourse() {
		
	}
	
	public LanguageCourse(int language_ID, int course_ID) {
		super();
		this.language_ID = language_ID;
		this.course_ID = course_ID;
	}

	public int getLanguage_ID() {
		return language_ID;
	}

	public void setLanguage_ID(int language_ID) {
		this.language_ID = language_ID;
	}

	public int getCourse_ID() {
		return course_ID;
	}

	public void setCourse_ID(int course_ID) {
		this.course_ID = course_ID;
	}
	
	
	
	
	

}
