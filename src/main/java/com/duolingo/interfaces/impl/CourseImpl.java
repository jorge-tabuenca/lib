package com.duolingo.interfaces.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duolingo.interfaces.ICourse;
import com.duolingo.model.Course;
import com.duolingo.model.User;
import com.duolingo.util.HibernateUtil;

public class CourseImpl implements ICourse{

	@Override
    public List<Course> getAllCourses() {

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
