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
    @Schema(required = true, example = "lise")
    private String firstName;
        @Schema(required = true, example = "nielsen")
    private String lastName;
    @Schema(required = true, example = "ringvejen")
    private String street;
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
    @Schema(example = "zipzip")
    private int zip;

    public PersonDTO(Person p) {
        this.id = p.getId();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.email = p.getEmail();
        Address a = p.getAddress();
        if (a != null) {
            this.street = a.getStreet();
            this.zip = a.getCityInfo().getZipcode();
            this.city = a.getCityInfo().getCity();
            this.additinalinfo = a.getAdditionalinfo();
        }
        for (int i = 0; i < p.getPhoneCollection().size(); i++) {
            this.phone += p.getPhoneCollection().get(i).getNumber();
        }
        for (int i = 0; i < p.getHobbyCollection().size(); i++) {
            this.hobby = p.getHobbyCollection().get(i).getName();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return street;
    }

    public void setAddress(String address) {
        this.street = address;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "PersonDTO{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", street=" + street + ", additinalinfo=" + additinalinfo + ", phone=" + phone + ", hobby=" + hobby + ", email=" + email + ", city=" + city + ", zip=" + zip + '}';
    }
}
