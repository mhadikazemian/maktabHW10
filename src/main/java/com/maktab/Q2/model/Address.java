package com.maktab.Q2.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Addresses")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "postal_address")
    private String postalAddress;
    @Column
    private String city;
    @Column(unique = true)
    @NotNull()
    private String number;

    public Address() {
    }

    public Address(String postalCode, String postalAddress, String city, String number) {
        this.postalCode = postalCode;
        this.postalAddress = postalAddress;
        this.city = city;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", postalCode='" + postalCode + '\'' +
                ", postalAddress='" + postalAddress + '\'' +
                ", city='" + city + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}//end of Address class
