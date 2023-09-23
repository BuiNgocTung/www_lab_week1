package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.entities.Log;

import java.util.List;

public class LogRepository {
    private EntityManager em;

    public LogRepository() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();

    }

    public List<Log> findAll(String accountID) {
       return em.createQuery("select l from Log l",Log.class)
               .getResultList();
    }
}
