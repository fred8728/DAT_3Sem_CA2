/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author emils
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Hobby.deleteAllRows", query = "DELETE from Hobby")
    
})
public class Hobby implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hobby_id")
    private int id;
    @Column(name = "hobby_name")
    private String name;
    @Column(name = "hobby_description")
    private String description;
    @JoinTable(name = "hobby_person", joinColumns = {
        @JoinColumn(name = "hobby_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "person_id", referencedColumnName = "id")})

    @ManyToMany(mappedBy = "hobbyCollection")
    private List<Person> personCollection = new ArrayList();

    public Hobby() {
    }

    public Hobby(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Person> getPersons() {
        return personCollection;
    }

    public void addPerson(Person p) {
        this.personCollection.add(p);
    }

//    @Override
//    public String toString() {
//        return "Hobby{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
//    }

}
