package com.mycompany.dao;

import com.mycompany.model.Book;
import com.mycompany.util.HibernateUtil;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDAO {
    public List getBooks(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
                Query q = session.createQuery("FROM Book");
                List<Book> books = q.getResultList();
                return books;

        } catch (Exception e) {
                System.out.println(e);
        } finally{
                session.close();
        }
        return null;
    }
    public Book getBookById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
                Query q = session.createQuery("FROM Book b Where b.id=:id");
                q.setParameter("id", id);
                Book book = (Book)q.getSingleResult();
                return book;

        } catch (Exception e) {
                System.out.println(e);
        } finally{
                session.close();
        }
        return null;
    }
    
    public boolean insertbook(Book newBook){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
                tx = session.beginTransaction();
                session.save(newBook);
                tx.commit();
                return true;
            } catch(Exception e){
                e.printStackTrace();  
            } finally {
                session.close();
            }  
        return false;
    }
}
