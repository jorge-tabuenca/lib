package com.duolingo.interfaces.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.duolingo.interfaces.IExercice;
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

}
