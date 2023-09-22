package vn.edu.iuh.fit.week01_lab_buingoctung_20064031.repositories;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.service.spi.InjectService;
import vn.edu.iuh.fit.week01_lab_buingoctung_20064031.db.Connection;
import vn.edu.iuh.fit.week01_lab_buingoctung_20064031.entities.GrantAccess;

import java.util.logging.Logger;

public class GrantAccessRepository {
    private  final Logger logger = Logger.getLogger(GrantAccessRepository.class.getName());
    private GrantAccessRepository grantAccessRepository;

    private EntityManager em;
    private EntityTransaction trans;
    public GrantAccessRepository() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
        trans = em.getTransaction();
    }

    public void insert(GrantAccess grantAccess) {

      try {
          trans.begin();
          em.persist(grantAccess);
          trans.commit();

      }catch (Exception e){
          trans.rollback();

e.printStackTrace();
      }
    }
}
