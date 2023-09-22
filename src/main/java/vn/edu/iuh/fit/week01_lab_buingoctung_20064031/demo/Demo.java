package vn.edu.iuh.fit.week01_lab_buingoctung_20064031.demo;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.week01_lab_buingoctung_20064031.db.Connection;

public class Demo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Connection.getInstance().getEntityManagerFactory();

        EntityManager em = emf.createEntityManager();

        EntityTransaction tr = em.getTransaction();

        tr.begin();
        try {
            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
    }

}
