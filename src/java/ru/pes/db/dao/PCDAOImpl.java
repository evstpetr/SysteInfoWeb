package ru.pes.db.dao;

import java.util.AbstractList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.pes.Objects.PC;


public class PCDAOImpl implements PCDAO<PC, String>{
    
    private Session currentSession;
    
    private Transaction currentTransaction;

    public PCDAOImpl(){
        
    }
    
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
    
    @Override
    public void persist(PC entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(PC entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public PC findById(String i) {
        long id = Long.valueOf(i);
        PC pc = (PC) getCurrentSession().get(PC.class, id);
        return pc;
    }

    @Override
    public void delete(PC entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PC> findAll() {
        List<PC> pcs = (List<PC>)  getCurrentSession().createQuery("from PC").list();
        return pcs;
    }

    @Override
    public void deleteAll() {
        List<PC> entityList = findAll();
        entityList.stream().forEach((entity) -> {
            delete(entity);
        });
    }
    
}
