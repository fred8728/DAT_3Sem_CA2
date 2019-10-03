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
        Address add = new Address("Mosebakken 5", 2670, "Greve");
        Person p = new Person ("Frederikke", 12345678, add);
        p.addHobbies("Synge");
        p.addHobbies("Klaver");
        
        Person p1 = new Person ("Marianne", 12354328, add);
        p1.addHobbies("Synge");
        
        Address add1 = new Address("Ishøjvej 50", 2670, "Ishøj");
        Person p2 = new Person("Frank", 39294392, add1);
        p2.addHobbies("Biler");
        
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.persist(p1);
            em.persist(p2);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        
        RegisterFacade facade = RegisterFacade.getRegisterFacade(emf);
        System.out.println("Person with phone__________");
        System.out.println(facade.findPersonswithPhoneNumber(12345678));
        System.out.println("All persons_____________");
        System.out.println(facade.getAllPersons().toString());
        System.out.println("Person count_________");
        System.out.println(facade.getPersonCount());
        System.out.println("Add Person -- new person added to allPersons");
        Address add5 = new Address("Karolinevej 2", 4000, "SønderJylland");
        System.out.println(facade.addPerson("Katinka", 87654321, add5, "Shopping"));
        System.out.println(facade.getAllPersons().toString());
        System.out.println("Delete person -- person is deleted from list");
        facade.deletePerson(4);
        System.out.println(facade.getAllPersons().toString());
        System.out.println("Get people from city");
        System.out.println(facade.getAllFromCity("Greve"));
                
    }
}
