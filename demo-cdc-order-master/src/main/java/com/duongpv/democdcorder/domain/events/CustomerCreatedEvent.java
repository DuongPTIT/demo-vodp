package com.duongpv.democdcorder.domain.events;

import com.duongpv.democdcorder.domain.Customer;

public class CustomerCreatedEvent extends CustomerEvent {
    private Customer customer;
    public CustomerCreatedEvent() {
    }

    public CustomerCreatedEvent(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
