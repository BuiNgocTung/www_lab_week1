package vn.edu.iuh.fit.week01_lab_buingoctung_20064031.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.week01_lab_buingoctung_20064031.db.Connection;
import vn.edu.iuh.fit.week01_lab_buingoctung_20064031.entities.Log;

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
