package vn.edu.iuh.fit.repositories;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.entities.Account;

import java.util.List;
import java.util.logging.Logger;

public class AccountRespository {
    private  final Logger logger = Logger.getLogger(AccountRespository.class.getName());
    private EntityManager em;
    private EntityTransaction trans;


    public AccountRespository() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
        trans = em.getTransaction();

    }
    public Account getAccountById(String id){

        return em.find(Account.class, id);
    }
    public List<Account> getAll() {
        return em.createQuery("select c from Account c", Account.class)
                .getResultList();
    }

    public boolean updateAccount(Account account){
        trans.begin();
        try{
            em.merge(account);
            trans.commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            trans.rollback();
        }
        return false;
    }

    public Account getAccountByEmailAndPassword(String email, String password){
        trans.begin();
        try{
            Account account = em.createQuery("SELECT a FROM Account a WHERE a.email = :email" +
                    " and a.password =: password", Account.class)
                    .setParameter("email", email)
                    .setParameter("password", password).getSingleResult();
            trans.commit();
            return account;
        }catch (Exception exception){
            exception.printStackTrace();
            trans.rollback();
        }
        return null;
    }
}
