/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import facades.RegisterFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fskn
 */
public class MakeTestData {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Address add = new Address("Mosebakken 5", "Greve");
        Person p = new Person("Frederikke", "12345678", "add");
        Phone ph = new Phone(12345678, "test");
        CityInfo ci = new CityInfo(1234, "lyngby");
        Hobby hob = new Hobby("100meter-kagebord", "når man tager en tur til joland");

        p.addHobby(hob);
        p.addPhone(ph);
        add.addPerson(p);
        ci.addAddress(add);

        try {
            em.getTransaction().begin();
            em.persist(p);
            em.persist(add);
            em.persist(ci);
            em.persist(hob);
            em.persist(ph);

            em.getTransaction().commit();

        } finally {
            em.close();
        }

        RegisterFacade facade = RegisterFacade.getRegisterFacade(emf);
        System.out.println("Person with phone__________");
        System.out.println(facade.getPersonByPhone(12345678));
        System.out.println("All persons_____________");
        System.out.println(facade.getAllPersons().toString());
        System.out.println("Person count_________");
        System.out.println(facade.getPersonCount());
        System.out.println("Add Person -- new person added to allPersons");
        Address add1 = new Address("Villavej 5", "Ishøj");
        Person p1 = new Person("Cathrine", "Hansen", "cathrinehansen@hotmail.com");
        Phone phone = new Phone(87654321, "My number");
        CityInfo info = new CityInfo(2635, "Ishøj");
        Hobby hobby = new Hobby("Shopping", "Køber unødvendigt");
        System.out.println(facade.addPerson(p1, phone, add1, info, hobby));
        System.out.println(facade.getAllPersons().toString());
        System.out.println("Specific hobbyCount");
        System.out.println(facade.getSpecificHobbyCount("Shopping"));
        System.out.println("Get people with hobby");
        System.out.println(facade.getPersonsWithSameHobby("Shopping"));
        System.out.println("Delete Person");
        facade.deletePerson(1);
        System.out.println(facade.getAllPersons());
        facade.getPersonByID(2);
        facade.editPerson(2, "brunhilde");
        System.out.println(facade.getAllPersons());
        System.out.println(facade.getAllPersonsFromCity("Ishøj"));
        System.out.println(facade.getPersonByID(2));
        System.out.println(facade.makeDTO(2));
        
        
    }
}
