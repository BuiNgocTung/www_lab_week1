package vn.edu.iuh.fit.repositories;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.entities.GrantAccess;

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
