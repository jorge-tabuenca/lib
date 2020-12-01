package com.duolingo.interfaces.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duolingo.interfaces.ICourse;
import com.duolingo.model.Course;
import com.duolingo.model.Language;
import com.duolingo.util.HibernateUtil;

public class CourseImpl implements ICourse{

	@Override
	public List<Course> getAllCourses() {
		
		Transaction t = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){

            t = session.beginTransaction();
            
            Course course = new Course();
            List<Course> list = session.createCriteria(course.getClass()).list();

            t.commit();

            return list;

        }catch (Exception e){
            return null;
        }
	}

	@Override
	public Course getCourseByLanguage(short courseId) {
		
		Transaction t = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){

            t = session.beginTransaction();
            
            Course course = new Course();
            course = session.find(Course.class, courseId);
            t.commit();

            return course;

        }catch (Exception e){
            return null;
        }
	}
}
