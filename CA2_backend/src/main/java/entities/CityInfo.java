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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author emils
 */
@Entity
public class CityInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ZIPCODE")
    private int zipcode;
    @Column(name = "CITY")
    private String city;
    
    
    @ManyToOne (cascade = CascadeType.PERSIST)
    private Address address;

    public CityInfo(int zipcode, String city) {
        this.zipcode = zipcode;
        this.city = city;
    }

    public CityInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address getAddress() {
        return address;
    }

    public void addAddress(Address address) {
        this.address = address;
        address.getCityInfo().add(this);
    }

    @Override
    public String toString() {
        return "CityInfo{" + "id=" + id + ", zipcode=" + zipcode + ", city=" + city + '}';
    }


}
