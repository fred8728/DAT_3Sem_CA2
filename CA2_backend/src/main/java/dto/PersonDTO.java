/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Person;
import entities.Phone;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

/**
 *
 * @author fskn
 */
public class PersonDTO {

    private int id;
    @Schema(required = true, example = "lise nielsen")
    private String name;
    @Schema(required = true, example = "ringvejen")
//    private String address;
//    @Schema(example = "[1,21212121,\"a phone number of johnny\"]")
//    private List<Phone> phone;
//    @Schema(example = "[\"Looking at Tom Hanks\",\"Fishing\"]")
//    private String hobby;
//    @Schema(example = "something-cph-@cphbusiness.dk")
    private String email;

    public PersonDTO(Person p) {
        this.name = p.getFirstName() + p.getLastName();
        //this.address = p.getAddress().getStreet();
//        this.phone = p.getPhoneCollection();
        this.email = p.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

//    public List<Phone> getPhone() {
//        return phone;
//    }
//
//    public void setPhone(List <Phone> phone) {
//        this.phone = phone;
//    }
//
//    public String getHobby() {
//        return hobby;
//    }
//
//    public void setHobby(String hobby) {
//        this.hobby = hobby;
//    }

    @Override
    public String toString() {
        return "PersonDTO{" + "id=" + id + ", name=" + name + /*", address=" + address + ", phone=" + phone + ", hobby=" + hobby +*/ '}';
    }

}
