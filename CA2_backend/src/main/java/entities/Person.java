package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
    @NamedQuery(name = "Person.deleteAllRows", query = "DELETE from Person"),
    @NamedQuery(name = "Person.getAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.getByPhone", query = "SELECT p FROM Person p WHERE p.phone = :phone")})

public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    
    @ElementCollection
    private List <String> hobbies = new ArrayList();
    
    private String phone;
    
    
    @ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JoinColumn(name="ADDRESS_ID")
    private Address address;
    
    public Person() {
    }

    public Person(String name, String phone, Address address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void addHobbies(String s) {
        hobbies.add(s);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        address.getPeople().add(this);
    }
}
