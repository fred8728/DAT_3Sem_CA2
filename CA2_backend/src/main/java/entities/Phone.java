/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author emils
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Phone.deleteAllRows", query = "DELETE from Phone")
    
})
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private int id;
    @Column(name = "phone_number")
    private int number;
    @Column(name = "phone_description")
    private String description;
    @ManyToOne
    private Person person;
    
    
    public Phone() {
    }

    public Phone(int number, String decription) {
        this.number = number;
        this.description = decription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    

//    @Override
//    public String toString() {
//        return "Phone{" + "id=" + id + ", number=" + number + ", description=" + description + '}';
//    }

   

    

}
