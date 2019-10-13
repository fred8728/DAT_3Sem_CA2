package rest;

import entities.Address;
import entities.CityInfo;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import utils.EMF_Creator;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.parsing.Parser;
import java.net.URI;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class RegisterResourceTest {

    private Person p1 = new Person("Ahmed", "Nielsen", "Niels@hotmail.dk");
    private Person p2 = new Person("Fred", "Mortensen Larsen", "kurt@hotmail.dk");
    private Person p3 = new Person("Emma", "Hansen", "ex@gmail.com");
    private Person p4 = new Person("Malene", "Hansen", "single@gmail.com");
    private Person p5 = new Person("zuzuki", "Hansen", "wrom@gmail.com");
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

    private static final int SERVER_PORT = 7777;
    private static final String SERVER_URL = "http://localhost/api";
    private static Person r1, r2;

    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
    private static HttpServer httpServer;
    private static EntityManagerFactory emf;

    static HttpServer startServer() {
        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    @BeforeAll
    public static void setUpClass() {
        //This method must be called before you request the EntityManagerFactory
        EMF_Creator.startREST_TestWithDB();
        emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST, Strategy.CREATE);

        httpServer = startServer();
        //Setup RestAssured
        RestAssured.baseURI = SERVER_URL;
        RestAssured.port = SERVER_PORT;
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterAll
    public static void closeTestServer() {
        //System.in.read();
        //Don't forget this, if you called its counterpart in @BeforeAll
        EMF_Creator.endREST_TestWithDB();
        httpServer.shutdownNow();
    }

    // Setup the DataBase (used by the test-server and this test) in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the EntityClass used below to use YOUR OWN (renamed) Entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        //r1 = new Person("Some txt","More text");
        //r2 = new Person("aaa","bbb");
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
            em.createNamedQuery("Phone.deleteAllRows").executeUpdate();
            em.createNamedQuery("Person.deleteAllRows").executeUpdate();
            em.createNamedQuery("Hobby.deleteAllRows").executeUpdate();
            em.createNamedQuery("Address.deleteAllRows").executeUpdate();
            em.createNamedQuery("CityInfo.deleteAllRows").executeUpdate();
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
            
//            em.persist(r1);
//            em.persist(r2); 
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Test
    public void testServerIsUp() {
        System.out.println("Testing is server UP");
        given().when().get("/person").then().statusCode(200);
    }

    //This test assumes the database contains two rows
    @Test
    public void testDummyMsg() throws Exception {
        given()
                .contentType("application/json")
                .get("/person/").then()
                .assertThat()
                .statusCode(HttpStatus.OK_200.getStatusCode())
                .body("msg", equalTo("Hello World"));
    }

//    @Test
//    public void testCount() throws Exception {
//        given()
//        .contentType("application/json")
//        .get("/api/person/count").then()
//        .assertThat()
//        .statusCode(HttpStatus.OK_200.getStatusCode())
//        .body("count", equalTo(2));   
//    }
}
