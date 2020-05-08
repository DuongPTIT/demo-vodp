package com.duongpv.democdcorder.domain;

public class Customer {
    private int id;
    private String name;
    private int creditLimit;
    private String company;

    public Customer() {
    }

    public Customer(int id, String name, int creditLimit, String company) {
        this.id = id;
        this.name = name;
        this.creditLimit = creditLimit;
        this.company = company;
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

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
