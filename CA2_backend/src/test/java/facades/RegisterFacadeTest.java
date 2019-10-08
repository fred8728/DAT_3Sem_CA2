package facades;

import entities.Address;
import entities.CityInfo;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import java.util.ArrayList;
import java.util.List;
import utils.EMF_Creator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class RegisterFacadeTest {

    private static EntityManagerFactory emf;
    private static RegisterFacade facade;
    private Person p1 = new Person("Ahmed", "Nielsen", "Niels@hotmail.dk");
    private Person p2 = new Person("Fred", "Mortensen Larsen", "kurt@hotmail.dk");
    private Person p3 = new Person("Emma", "Hansen", "ex@gmail.com");
    private Person p4 = new Person("Malene", "Hansen", "single@gmail.com");
    private Address add1 = new Address("Mosebakken 5", "Greve");
    private Address add2 = new Address("Holmen 43", "Ishøj");
    private Address add3 = new Address("Blågaards plads", "København nv");
    private Phone phone1 = new Phone(12345678, "Home number");
    private Phone phone2 = new Phone(97654321, "New number");
    private Phone phone3 = new Phone(89765432, "Unknown number");
    private Phone phone4 = new Phone(78654324, "Private number");
    private CityInfo cinfo1 = new CityInfo(2670, "Greve");
    private CityInfo cinfo2 = new CityInfo(2635, "Ishøj");
    private CityInfo cinfo3 = new CityInfo(2200, "København nv");
    private Hobby hobby1 = new Hobby("Synge", "Stiller op i x factor");
    private Hobby hobby2 = new Hobby("Game", "Call of duty");
    private Hobby hobby3 = new Hobby("Shopping", "Unødvendig brug af dankort");
    private Hobby hobby4 = new Hobby("Danse", "Break-dance og twerk");

    public RegisterFacadeTest() {
    }

    //@BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/startcode_test",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
        facade = RegisterFacade.getRegisterFacade(emf);
    }

    /*   **** HINT **** 
        A better way to handle configuration values, compared to the UNUSED example above, is to store those values
        ONE COMMON place accessible from anywhere.
        The file config.properties and the corresponding helper class utils.Settings is added just to do that. 
        See below for how to use these files. This is our RECOMENDED strategy
     */
    @BeforeAll
    public static void setUpClassV2() {
        emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST, Strategy.DROP_AND_CREATE);
        facade = RegisterFacade.getRegisterFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();

        p1.addHobby(hobby1);
        p2.addHobby(hobby2);
        p3.addHobby(hobby3);
        p4.addHobby(hobby4);
        p1.addPhone(phone1);
        p2.addPhone(phone2);
        p3.addPhone(phone3);
        p4.addPhone(phone4);
        add1.addPerson(p1);
        add2.addPerson(p2);
        add3.addPerson(p3);
        add3.addPerson(p4);
        cinfo1.addAddress(add1);
        cinfo2.addAddress(add2);
        cinfo3.addAddress(add3);
        try {
            em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.persist(p4);
            em.persist(hobby1);
            em.persist(hobby2);
            em.persist(hobby3);
            em.persist(hobby4);
            em.persist(phone1);
            em.persist(phone2);
            em.persist(phone3);
            em.persist(phone4);
            em.persist(add1);
            em.persist(add2);
            em.persist(add3);
            em.persist(cinfo1);
            em.persist(cinfo2);
            em.persist(cinfo3);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    //Need to insert some kind of delete in the setup method (tried but didnt work)
    /*@Test
    public void getPersonCountTest() {
        assertEquals(4, facade.getPersonCount());
    }*/

    @Test
    public void checkListsAreEqual() {

        Person p1 = new Person("Ahmed", "Nielsen", "Niels@hotmail.dk");
        Person p2 = new Person("Fred", "Mortensen Larsen", "kurt@hotmail.dk");
        Person p3 = new Person("Emma", "Hansen", "ex@gmail.com");
        Person p4 = new Person("Malene", "Hansen", "single@gmail.com");

        List<Person> persons = new ArrayList();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        
        assertNotNull(persons);
        assertNotNull(facade.getAllPersons());
        assertEquals(persons.size(), facade.getAllPersons().size());
    }
}
