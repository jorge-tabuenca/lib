package com.duolingo.interfaces;

import java.util.List;

import com.duolingo.model.Course;
import com.duolingo.model.LanguageCourse;

public interface ILanguageCourse {
	
	public List<LanguageCourse> getAllCourses(short originLang, short destLang);
	
	public void insertCourse(short originLang, short destLang);

}
