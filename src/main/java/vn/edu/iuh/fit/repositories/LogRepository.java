package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.entities.Log;

import java.util.List;

public class LogRepository {
    private EntityManager em;
    private EntityTransaction trans;
    public LogRepository() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
        trans = em.getTransaction();
    }

    public List<Log> findAll(String accountID) {
       return em.createQuery("select l from Log l",Log.class)
               .getResultList();
    }
    public boolean addLog(Log log){
        trans.begin();
        try {
            em.persist(log);
            trans.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            trans.rollback();
        }
        return false;
    }

}
