package ru.pes.db.service;

import java.util.List;
import ru.pes.Objects.PC;
import ru.pes.db.dao.PCDAOImpl;


public class PCService {

    private static PCDAOImpl pcDao;
    
    public PCService(){
        pcDao = new PCDAOImpl();
    }
    
    public void persist(PC pc){
        pcDao.openCurrentSessionWithTransaction();
        pcDao.persist(pc);
        pcDao.closeCurrentSessionWithTransaction();
    }
    
    public void update(PC pc){
        pcDao.closeCurrentSessionWithTransaction();
        pcDao.update(pc);
        pcDao.closeCurrentSessionWithTransaction();
    }
    
    public PC findById(String id){
        pcDao.openCurrentSession();
        PC pc = pcDao.findById(id);
        pcDao.closeCurrentSession();
        return pc;
    }
    
    public void delete(String id){
        pcDao.openCurrentSessionWithTransaction();
        PC pc = pcDao.findById(id);
        pcDao.delete(pc);
        pcDao.closeCurrentSessionWithTransaction();
    }
    
    public List<PC> findAll(){
        pcDao.openCurrentSession();
        List<PC> pcs = pcDao.findAll();
        pcDao.closeCurrentSession();
        return pcs;
    }
    
    public void deleteAll(){
        pcDao.openCurrentSessionWithTransaction();
        pcDao.deleteAll();
        pcDao.closeCurrentSessionWithTransaction();
    }
    
    public PCDAOImpl pcDao(){
        return pcDao;
    }
    
}
