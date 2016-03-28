package ru.pes.db.dao;


import java.util.List;
import ru.pes.Objects.PC;


public class PCDAOImpl extends DAO<PC, String>{
    
    public PCDAOImpl(){
        super();
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
