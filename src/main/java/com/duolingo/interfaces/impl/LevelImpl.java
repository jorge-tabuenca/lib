package com.duolingo.interfaces.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.duolingo.interfaces.ILevel;
import com.duolingo.model.Category;
import com.duolingo.model.Level;
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

	@Override
	public List<Level> getAllLevels(int categoryID) {

		Transaction t = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){

            t = session.beginTransaction();
            
            String hql = "SELECT * FROM Level WHERE Category_ID = '" + categoryID +"';";
            
            List<Level> list = session.createNativeQuery(hql).addEntity(Level.class).getResultList();
            t.commit();

            return list;

        }catch (Exception e){
            return null;
        }
		
	}

}
