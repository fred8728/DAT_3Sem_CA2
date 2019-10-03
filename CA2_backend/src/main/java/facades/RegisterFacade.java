package facades;

import entities.Address;
import entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class RegisterFacade {

    private static RegisterFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private RegisterFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static RegisterFacade getRegisterFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new RegisterFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //TODO Remove/Change this before use
    public long getPersonCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long personCount = (long) em.createQuery("SELECT COUNT(r) FROM Person r").getSingleResult();
            return personCount;
        } finally {
            em.close();
        }
    }

    public List<Person> getAllPersons() {
        EntityManager em = getEntityManager();
        try {
            List<Person> id = em.createQuery("select b from Person b").getResultList();
            return id;
        } finally {
            em.close();
        }
    }

    public Person findPersonswithPhoneNumber(String Phone) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            return (Person) em.createQuery("SELECT s FROM Person s WHERE s.phone = :phone", Person.class).setParameter("phone", Phone).getSingleResult();
        } finally {
            em.close();
        }
    }

    /* public List<Person> findAllPersonswithHobbie(String hobbie) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();     //  SELECT e FROM Employee e JOIN e.projects p JOIN e.projects p2 WHERE p.name = :p1 and p2.name = :p2
            TypedQuery query = em.createQuery("SELECT s FROM Person s JOIN s.ID a JOIN s.ID a2 WHERE a.Person_ID = :hobbie and a2.name = :p2", Person.class);
            query.setParameter("hobbie", hobbie);
            em.getTransaction().commit();
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    
     */
    public void populate() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Address.deleteAllRows").executeUpdate();
            em.persist(new Address("landevej", 2660, "brøndby"));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
