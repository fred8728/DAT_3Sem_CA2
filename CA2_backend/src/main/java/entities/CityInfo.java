/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author emils
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "CityInfo.deleteAllRows", query = "DELETE from CityInfo")
    
})
public class CityInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_info_id")
    private int id;
    @Column(name = "zipcode")
    private int zipcode;
    @Column(name = "city")
    private String city;


    @OneToMany(mappedBy = "cityInfo")
    private transient List<Address> address = new ArrayList();

    public CityInfo(int zipcode, String city) {
        this.zipcode = zipcode;
        this.city = city;
        this.address = new ArrayList();
    }

    public CityInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<Address> getAddress() {
        return address;
    }

    public void addAddress(Address add) {
        this.address.add(add);
        add.setCityInfo(this);
    }
    
    

//    @Override
//    public String toString() {
//        return "CityInfo{" + "id=" + id + ", zipcode=" + zipcode + ", city=" + city + '}';
//    }

}
