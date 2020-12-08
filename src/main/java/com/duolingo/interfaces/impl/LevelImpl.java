package com.duolingo.interfaces.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.duolingo.interfaces.ILevel;
import com.duolingo.util.HibernateUtil;

public class LevelImpl implements ILevel{

	@Override
	public void insertLevel(int tierLevel, String nameLevel, int categoryID) {
		
		Transaction t = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			 t = session.beginTransaction();		 
			 
			 String query = "INSERT INTO Level (Tier, Name, Category_ID) VALUES ('"+tierLevel+"', '"+nameLevel+"', '"+categoryID+"');";
			 
			 session.createNativeQuery(query).executeUpdate();
			 
			 session.update(session);
			 
			 t.commit();
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	

}
