package facades;

import entities.Address;
import entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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

    //Virker - Get person count
    public int getPersonCount() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Person.count");
            return  Integer.parseInt(query.getSingleResult().toString());
        } finally {
            em.close();
        }
    }
       
    //skal laves
    public int getCountOfHobby() {
        EntityManager em = emf.createEntityManager();
        try {
           
            return 0;
        } finally {
            em.close();
        }
    }

    //Virker - viser id, navn og phone
    public List<Person> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        try {

            List <Person> getAll = em.createNamedQuery("Person.getAll").getResultList();
            return getAll;

        } finally {
            em.close();
        }   
    }

    
    //Virker - anvend namedquery i person klassen
    public Person findPersonswithPhoneNumber(int Phone) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            return (Person) em.createQuery("SELECT s FROM Person s WHERE s.phone = :phone", Person.class)
                    .setParameter("phone", Phone).getSingleResult();
        } finally {
            em.close();
        }
    }
    
    //Virker
    public List<Person> getAllFromCity(String city){
        EntityManager em = emf.createEntityManager();
        try{
            Query query = em.createQuery("SELECT p FROM Person p JOIN p.address a where a.city=:city")
                    .setParameter("city", city);
            return query.getResultList(); 
        }finally{
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
    
    //Hvad gør denne?
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
    
    
    //Virker
    public Person addPerson(String name, int phone, Address add, String hobby) {
        Person p = new Person (name, phone, add);
        p.addHobbies(hobby);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }
    
    //Virker ikke 100 % - ikke færdig 
    public Person deletePerson(int id) {
        EntityManager em = emf.createEntityManager();
        Person p = em.find(Person.class, id);
        Address add = p.getAddress();
        Person p1 = new Person();
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.remove(add);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
        return p;
    }
    
    
    
}
