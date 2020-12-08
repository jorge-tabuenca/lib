package com.duolingo.interfaces.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.duolingo.interfaces.ILanguage;
import com.duolingo.model.Course;
import com.duolingo.model.Language;
import com.duolingo.util.HibernateUtil;

public class LanguageImpl implements ILanguage{

	@Override
	public List<Language> getAllLanguages() {

		Transaction t = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            t = session.beginTransaction();
            Language language = new Language();
            List<Language> list = session.createCriteria(language.getClass()).list();

            t.commit();

            return list;

        }catch (Exception e){
            return null;
        }
	}

	@Override
	public Language getLanguageByLanguage(short languageId) {
		
		Transaction t = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){

            t = session.beginTransaction();
            
            Language language = new Language();
            language = session.find(Language.class, languageId);
            t.commit();

            return language;

        }catch (Exception e){
            return null;
        }
	}
}
