package com.duolingo.interfaces.impl;

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
	public List<Category> getAllCategories(int courseID) {
		
		Transaction t = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){

            t = session.beginTransaction();
            
            String hql = "SELECT NAME FROM Category WHERE Language_Course_ID = " + courseID;
            //List<Category> list = session.createQuery(hql).getResultList();
            List<Category> list = session.createNativeQuery(hql).addEntity(Category.class).getResultList();
            System.out.println(list.size());
            
            
            t.commit();

            return list;

        }catch (Exception e){
            return null;
        }
	}
}