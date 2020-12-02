package com.duolingo.interfaces;

import java.util.List;

import com.duolingo.model.Course;
import com.duolingo.model.LanguageCourse;

public interface ILanguageCourse {
	
	public List<LanguageCourse> getAllCourses(int originLang, int destLang);
	
	public void insertCourse(int originLang, int destLang);

}
