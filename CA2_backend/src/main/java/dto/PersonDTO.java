/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Address;
import entities.Hobby;
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
    private String address;
    @Schema(required = true, example = "info")
    private String additinalinfo;
    @Schema(example = "[1,21212121,\"a phone number of johnny\"]")
    private int phone;
    @Schema(example = "[\"Looking at Tom Hanks\",\"Fishing\"]")
    private String hobby = "";
    @Schema(example = "something-cph-@cphbusiness.dk")
    private String email;
    @Schema(example = "placeholder")
    private String city;

    public PersonDTO(Person p) {
        this.id = p.getId();
        this.name = p.getFirstName() + " " + p.getLastName();
        this.address = p.getAddress().getStreet();
        this.additinalinfo = p.getAddress().getAdditionalinfo();
        for (int i = 0; i < p.getPhoneCollection().size(); i++) {
            this.phone += p.getPhoneCollection().get(i).getNumber();
        }
        this.email = p.getEmail();
        for (int i = 0; i < p.getHobbyCollection().size(); i++) {
            this.hobby = p.getHobbyCollection().get(i).getName();
        }
        this.city = p.getAddress().getCityInfo().getCity();
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdditinalinfo() {
        return additinalinfo;
    }

    public void setAdditinalinfo(String additinalinfo) {
        this.additinalinfo = additinalinfo;
    }

    @Override
    public String toString() {
        return "PersonDTO{" + "id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", hobby=" + hobby + ", email=" + email + ", city=" + city + '}';
    }

}
