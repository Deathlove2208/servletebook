
package com.mycompany.dao;

import com.mycompany.model.Book;
import com.mycompany.model.User;
import com.mycompany.util.HibernateUtil;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class DAO {
    public Session session = null;
    public DAO(){
        session = HibernateUtil.getSessionFactory().openSession();
    }
    public User getUser(String username){
        User user = null;
        try {
                Query q = this.session.createQuery("FROM User u WHERE u.username=:uname");
                q.setParameter("uname", username);
                user = (User) q.getSingleResult();

        } catch (Exception e) {
                System.out.println(e);
        } finally{
                session.close();
        }
        return user;
    }
    public List getAllBook(){
        try {
                Query q = this.session.createQuery("FROM Book");
                List<Book> books = q.getResultList();
                return books;

        } catch (Exception e) {
                System.out.println(e);
        } finally{
                session.close();
        }
        return null;
    }
    
    public boolean insertUser(User newUser){	
        Transaction tx = null;
        String username = newUser.getUsername();
        User u = this.getUser(username);
        if(u == null) {
            try {
                this.session = HibernateUtil.getSessionFactory().openSession();
                tx = this.session.beginTransaction();
                this.session.save(newUser);
                tx.commit();
                return true;
            } catch(Exception e){
                e.printStackTrace();  
            } finally {
                this.session.close();
            }  

        }
        return false;
    }
}