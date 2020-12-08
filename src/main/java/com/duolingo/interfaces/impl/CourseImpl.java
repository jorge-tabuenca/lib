package com.duolingo.interfaces.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duolingo.interfaces.ICourse;
import com.duolingo.model.Course;
import com.duolingo.model.User;
import com.duolingo.util.HibernateUtil;

public class CourseImpl implements ICourse{

	@Override
	public List<Course> getAllCourses(int originLang, int destLang) {
		
		Transaction t = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){

            t = session.beginTransaction();
            
            String hql = "FROM Language_Course WHERE Language_ID = :originLang AND Course_ID = :destLang";
            Query query = session.createQuery(hql).setParameter("originLang", originLang).setParameter("destLang", destLang);
            List<Course> list = query.list();

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
            
            String hql = "select name FROM course where ID = :courseId;";
            Query query = session.createQuery(hql).setParameter("courseId", courseId);
            List<Course> list = query.list();
            
            Course course = new Course();
            course = session.find(Course.class, courseId);
            t.commit();

            return course;

        }catch (Exception e){
            return null;
        }
	}

	@Override
	public List<Course> getAll() {
		
		Transaction t = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){

            t = session.beginTransaction();

            List<Course> list = session.createCriteria(Course.class).list();

            t.commit();

            return list;

        }catch (Exception e){
            return null;
        }
    }

}
