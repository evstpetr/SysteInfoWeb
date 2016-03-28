package ru.pes.db.dao;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public abstract class DAO<T, Id> {
    
    private Session currentSession;   
    private Transaction currentTransaction;
    
    public Session openCurrentSession(){
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
    
    public Session openCurrentSessionWithTransaction(){
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    
    public void closeCurrentSession(){
        currentSession.close();
    }
    
    public void closeCurrentSessionWithTransaction(){
        currentTransaction.commit();
        currentSession.close();
    }
    
    private static SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
    
    public Session getCurrentSession(){
        return currentSession;
    }
    
    public void setCurrentSession(Session currSession){
        this.currentSession = currSession;
    }
    
    public Transaction getCurrentTransaction(){
        return currentTransaction;
    }
    
    public void setCurrentTransaction(Transaction currentTransaction){
        this.currentTransaction = currentTransaction;
    }
    
    public abstract void persist(T entity);
    
    public abstract void update(T entity);
    
    public abstract T findById(Id id);
    
    public abstract void delete(T entity);
    
    public abstract List<T> findAll();
    
    public abstract void deleteAll();
    
}
