package com.viettel.democdc.Domain;

import javax.persistence.*;

@Entity
@Table(name = "customer_info")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "credit_limit")
    private Integer creditLimit;

    @Column(name = "company")
    private String company;

    public Customer() {
    }

    public Customer(String name, Integer creditLimit, String company) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
