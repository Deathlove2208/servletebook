package com.mycompany.dao;

import com.mycompany.model.User;
import com.mycompany.util.HibernateUtil;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO {
    public User getUser(String username){
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = null;
        try {
                Query q = session.createQuery("FROM User u WHERE u.username=:uname");
                q.setParameter("uname", username);
                user = (User) q.getSingleResult();

        } catch (Exception e) {
                System.out.println(e);
        } finally{
                session.close();
        }
        return user;
    }
    
    public boolean insertUser(User newUser){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        String username = newUser.getUsername();
        User u = this.getUser(username);
        if(u == null) {
            try {
                tx = session.beginTransaction();
                session.save(newUser);
                tx.commit();
                return true;
            } catch(Exception e){
                e.printStackTrace();  
            } finally {
                session.close();
            }  

        }
        return false;
    }
}
