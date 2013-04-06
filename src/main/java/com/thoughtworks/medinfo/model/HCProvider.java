package com.thoughtworks.medinfo.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "hcproviders", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})

public class HCProvider implements Serializable {

    private static final long serialVersionUID = -4060739788760795254L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "phone")
    private String phone;

    @NotNull
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private HCPRole role;

    @NotNull
    @Column(name = "pincode")
    private String pincode;

    @NotNull
    @Column(name = "state")
    private String state;

    @NotNull
    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public HCPRole getRole() {
        return role;
    }

    public void setRole(HCPRole role) {
        this.role = role;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}