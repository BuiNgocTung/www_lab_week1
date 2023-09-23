package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.entities.Role;

public class RoleRepository {


    private EntityManager em;
    private EntityTransaction trans;
    public RoleRepository() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
        trans = em.getTransaction();
    }


    public Role findRoleByAccountId(String accountId) {
        try {
            TypedQuery<Role> query = em.createQuery(
                    "SELECT r FROM GrantAccess ga " +
                            "INNER JOIN ga.role r " +
                            "INNER JOIN ga.account a " +
                            "WHERE a.accountID = :accountID", Role.class);
            query.setParameter("accountID", accountId);
            return query.getSingleResult();
        } catch (Exception e) {
            // Handle any exceptions (e.g., NoResultException if no result is found)
            return null; // or throw an exception or handle as needed
        }
    }
}
