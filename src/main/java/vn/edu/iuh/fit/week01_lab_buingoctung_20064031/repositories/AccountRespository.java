package vn.edu.iuh.fit.week01_lab_buingoctung_20064031.repositories;


import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.week01_lab_buingoctung_20064031.db.Connection;
import vn.edu.iuh.fit.week01_lab_buingoctung_20064031.entities.Account;

import java.util.logging.Logger;

public class AccountRespository {
    private  final Logger logger = Logger.getLogger(AccountRespository.class.getName());
    private EntityManager em;

    public AccountRespository() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public Account getAccountByEmail(EntityManager em, String email) {
        try {
            TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a WHERE a.email = :email", Account.class);
            query.setParameter("email", email);
            return query.getSingleResult();
        } catch (NoResultException e) {

            return null;
        }
    }
}
