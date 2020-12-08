package com.duolingo.interfaces;

import java.util.List;

import com.duolingo.model.Course;

public interface ICourse {
	
	public List<Course> getAllCourses(int originLang, int destLang);
	
	public List<Course> getAll();
	
	public Course getCourseByLanguage(short courseId);

}
