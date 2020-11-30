package com.duolingo.interfaces.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.duolingo.interfaces.ICategory;
import com.duolingo.model.Category;
import com.duolingo.util.HibernateUtil;

public class CategoryImpl implements ICategory{

	@Override
	public List<Category> getAllCategories(String courseName) {
		
		Transaction t = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){

            t = session.beginTransaction();
            
            String hql = "FROM Category C WHERE C.name= :courseName";
            Query query = session.createQuery(hql).setParameter("courseName", courseName);
            List list = query.list();

            t.commit();

            return list;

        }catch (Exception e){
            return null;
        }
	}
}