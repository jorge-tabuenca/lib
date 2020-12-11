package com.duolingo.interfaces.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.duolingo.interfaces.IExercice;
import com.duolingo.model.Category;
import com.duolingo.model.Course;
import com.duolingo.model.Exercice;
import com.duolingo.util.HibernateUtil;

public class ExerciceImpl implements IExercice{

	@Override
	public void insertExercice(Exercice exercice) {
		
		Transaction t = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			 t = session.beginTransaction();

			 session.save(exercice);
			 
			 t.commit();
			 
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public List<Exercice> getAllExerciceByCategoryId(int categoryID) {
		Transaction t = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){

            t = session.beginTransaction();
            
            String hql = "SELECT * FROM Exercice WHERE CATEGORY_ID = " + categoryID;
            List<Exercice> list = session.createNativeQuery(hql).addEntity(Exercice.class).getResultList();
            t.commit();

            return list;

        }catch (Exception e){
            return null;
        }
	}	
}
