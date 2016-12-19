package simplejpa;

import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;

public class SimpleJPA {

    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {
        try {
            emf = javax.persistence.Persistence.createEntityManagerFactory("SimpleJPAPU");
            em = emf.createEntityManager();
        } catch (PersistenceException ex) {
            System.out.println("Error connecting to database");
            ex.printStackTrace();
            return;
        }

        Person p = new Person("Hendro Steven", "Salatiga, Indonesia", "+6281390989669");
        persist(p);
    }

    public static void persist(Object object) {
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        /* // don't close the connection, we'll need it again for next operation
        finally {
            em.close();
        } */
    }

}
