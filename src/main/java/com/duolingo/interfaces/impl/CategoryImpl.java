package com.duolingo.interfaces.impl;

import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.duolingo.interfaces.ICategory;
import com.duolingo.model.Category;
import com.duolingo.model.LanguageCourse;
import com.duolingo.util.HibernateUtil;

public class CategoryImpl implements ICategory{

	@Override
	public List<Category> getAllCategories(int languageID, int courseID) {
		
		Transaction t = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){

            t = session.beginTransaction();
            
            String hql = "SELECT * FROM Category WHERE Language_ID = " + languageID + " AND Course_ID = " + courseID;
            List<Category> list = session.createNativeQuery(hql).addEntity(Category.class).getResultList();
            t.commit();

            return list;

        }catch (Exception e){
            return null;
        }
	}

	@Override
	public void insertCategory(int languageID, int courseID, String name) {
		
		Transaction t = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			 t = session.beginTransaction();		 
			 
			 String query = "INSERT INTO duolingobbdd.category (NAME, Course_ID, Language_ID) VALUES ('"+name+"', '"+courseID+"', '"+languageID+"');";
			 
			 session.createNativeQuery(query).executeUpdate();
			 
			 session.update(session);
			 
			 t.commit();
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}