package com.duolingo.interfaces.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.duolingo.interfaces.ILanguageCourse;
import com.duolingo.model.Course;
import com.duolingo.model.LanguageCourse;
import com.duolingo.model.User;
import com.duolingo.util.HibernateUtil;

public class LanguageCourseImpl implements ILanguageCourse{

	@Override
	public List<LanguageCourse> getAllCourses(int originLang, int destLang) {
		
		Transaction t = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){

            t = session.beginTransaction();
            
            String sql = null;
            if (originLang == 0) {
				sql = "SELECT * FROM Language_Course WHERE Course_ID = " +destLang;
			}else if (destLang == 0) {
				sql = "SELECT * FROM Language_Course WHERE Language_ID = " +originLang;
			}else {
				sql = "SELECT * FROM Language_Course WHERE Language_ID = "+originLang+ " AND Course_ID = "+destLang;
			}            
            
            Query query =  session.createNativeQuery(sql);
            List<LanguageCourse> list = query.list();
            
            // String hql = "FROM Language_Course LC WHERE LC.Language_ID= 1";
            // Query query = session.createQuery(hql).setParameter("originLang", originLang).setParameter("destLang", destLang);
            // List<LanguageCourse> list = query.list();

            t.commit();

            return list;

        }catch (Exception e){
            return null;
        }
	}

	@Override
	public void insertCourse(int originLang, int destLang) {

		Transaction t = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			 t = session.beginTransaction();
			 
			 LanguageCourse lc = new LanguageCourse();
			 lc.setLanguage_ID(originLang);
			 lc.setCourse_ID(destLang);
			 
			 session.save(lc);
			 
			 t.commit();
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
