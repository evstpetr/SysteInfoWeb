package ru.pes.db.service;

import java.util.List;
import ru.pes.Objects.Soft;
import ru.pes.db.dao.SoftDAOImpl;


public class SoftService {

    private static SoftDAOImpl softDao;
    
    public SoftService(){
        softDao = new SoftDAOImpl();
    }
    
    public void persist(Soft soft){
        softDao.openCurrentSessionWithTransaction();
        softDao.persist(soft);
        softDao.closeCurrentSessionWithTransaction();
    }
    
    public void update(Soft soft){
        softDao.closeCurrentSessionWithTransaction();
        softDao.update(soft);
        softDao.closeCurrentSessionWithTransaction();
    }
    
    public Soft findById(String id){
        softDao.openCurrentSession();
        Soft soft = softDao.findById(id);
        softDao.closeCurrentSession();
        return soft;
    }
    
    public void delete(String id){
        softDao.openCurrentSessionWithTransaction();
        Soft soft = softDao.findById(id);
        softDao.delete(soft);
        softDao.closeCurrentSessionWithTransaction();
    }
    
    public List<Soft> findAll(){
        softDao.openCurrentSession();
        List<Soft> softs = softDao.findAll();
        softDao.closeCurrentSession();
        return softs;
    }
    
    public void deleteAll(){
        softDao.openCurrentSessionWithTransaction();
        softDao.deleteAll();
        softDao.closeCurrentSessionWithTransaction();
    }
    
    public SoftDAOImpl softDao(){
        return softDao;
    }
    
}
