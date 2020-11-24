package com.duolingo.interfaces.impl;

import com.duolingo.interfaces.IUser;
import com.duolingo.model.User;
import com.duolingo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserImpl implements IUser {

    @Override
    public List<User> getAllUsers() {

        Transaction t = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            t = session.beginTransaction();

            List<User> list = session.createCriteria(User.class).list();

            t.commit();

            return list;

        }catch (Exception e){
            return null;
        }
    }

    public User insertUser(User user) {
        return null;
    }
}
