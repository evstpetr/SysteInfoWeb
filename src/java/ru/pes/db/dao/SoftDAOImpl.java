package ru.pes.db.dao;

import java.util.List;
import ru.pes.Objects.Soft;

public class SoftDAOImpl extends DAO<Soft, String> {

    public SoftDAOImpl() {
        super();
    }

    @Override
    public void persist(Soft entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Soft entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Soft findById(String i) {
        int id = Integer.valueOf(i);
        Soft soft = (Soft) getCurrentSession().get(Soft.class, id);
        return soft;
    }

    @Override
    public void delete(Soft entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Soft> findAll() {
        List<Soft> soft = (List<Soft>) getCurrentSession().createQuery("from PC_SOFT").list();
        return soft;
    }

    @Override
    public void deleteAll() {
        List<Soft> entityList = findAll();
        entityList.stream().forEach((entity) -> {
            delete(entity);
        });
    }

}
