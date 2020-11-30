package com.duolingo.interfaces.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.duolingo.interfaces.ICourse;
import com.duolingo.model.Course;
import com.duolingo.util.HibernateUtil;

public class CourseImpl implements ICourse{

	@Override
	public List<Course> getAllCourses(String originLang, String destLang) {
		
		Transaction t = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){

            t = session.beginTransaction();
            
            String hql = "FROM Course C WHERE C.name= :originLang AND C.name = :destLang";
            Query query = session.createQuery(hql).setParameter("originLang", originLang).setParameter("destLang", destLang);
            List list = query.list();

            t.commit();

            return list;

        }catch (Exception e){
            return null;
        }
	}
}
