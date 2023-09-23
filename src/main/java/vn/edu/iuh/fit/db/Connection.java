package vn.edu.iuh.fit.db;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {
    private static Connection instance;
    private EntityManagerFactory emf;
    private Connection() {

        emf = Persistence.createEntityManagerFactory("week01_lab_BuiNgocTung_20064031");
    }
    public static Connection getInstance() {
        if (instance ==null)
            instance = new Connection();
        return instance;
    }
    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

}
