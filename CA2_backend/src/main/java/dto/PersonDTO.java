/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Person;

/**
 *
 * @author fskn
 */
public class PersonDTO {
    
    private int id;
    private String name;
    private String address;
    private int phone;
    private String hobby;

    public PersonDTO(Person p) {
        this.name = p.getFirstName() + p.getLastName();
        this.address = p.getAddress().getStreet();
        this.phone = p.getPhone();
        this.hobby = p.getHobbies().get(id);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "PersonDTO{" + "id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", hobby=" + hobby + '}';
    }
    
    
}
