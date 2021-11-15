package com.mycompany.dao;

import com.mycompany.model.Book;
import com.mycompany.util.HibernateUtil;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDAO {
    public List<Book> getBooks(String query){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
        	String hql;
        	List<Book> books = null;
        	 switch ( query ) {
        	    
        	    case "trending":
        	    case "best":
        	    case "isNew":
        	    	 hql = String.format("FROM Book WHERE %s = :value", query);
        	    	 Query q = session.createQuery(hql);
        	         q.setParameter("value", "yes");
        	         books = q.getResultList();
        	    	 break;
        	    default:
        	    	hql = "FROM Book WHERE (:title IS NULL) OR title LIKE :title";
        	    	Query q2 = session.createQuery(hql);
                    q2.setParameter("title", '%' +query+ '%');
                    books = q2.getResultList();
        	}
            
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
    
    public boolean insertBook(Book newBook){
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
    
    public boolean deleteBook(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            Query q = session.createQuery("DELETE Book b Where b.id=:id");
            tx = session.beginTransaction();
            q.setParameter("id", id);
            q.executeUpdate();
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
