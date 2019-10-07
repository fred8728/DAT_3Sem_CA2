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
import javax.persistence.Table;

/**
 *
 * @author emils
 */
@Entity
public class Hobby implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOBBY_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinTable(name = "HOBBY_PERSON", joinColumns = {
        @JoinColumn(name = "HOBBY_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID")})

    @ManyToMany(mappedBy = "hobbyCollection")
    private List<Person> personCollection = new ArrayList();

    public Hobby() {
    }

    public Hobby(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "Hobby{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }

}
