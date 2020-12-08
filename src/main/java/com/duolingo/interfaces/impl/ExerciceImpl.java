package com.duolingo.interfaces.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.duolingo.interfaces.IExercice;
import com.duolingo.model.Exercice;
import com.duolingo.util.HibernateUtil;

public class ExerciceImpl implements IExercice{

	@Override
	public void insertExercice(String name, String WORD1, String WORD2, String WORD3, String WORD4) {
		
		int status = 1;
		int typeExercice = 7;
		
		
		Transaction t = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			 t = session.beginTransaction();
			 
			 Exercice exercice = new Exercice("name", status, typeExercice, WORD1, WORD2, WORD3, WORD4);

			 session.save(exercice);
			 
			 t.commit();
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
