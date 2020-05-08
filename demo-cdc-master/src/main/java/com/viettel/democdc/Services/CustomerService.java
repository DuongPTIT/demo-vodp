package com.viettel.democdc.Services;

import com.viettel.democdc.Domain.Customer;
import com.viettel.democdc.Domain.Operation;
import com.viettel.democdc.Domain.Outbox;
import com.viettel.democdc.Repositories.CustomerRepository;
import com.viettel.democdc.Repositories.OutboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OutboxRepository outboxRepository;


    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Transactional
    public int createCustomer(Customer customer) {
        customerRepository.save(customer);
        Outbox outbox = Outbox.createOutboxWithCustomer(customer, Operation.CustomerCreated);
        outboxRepository.save(outbox);
        System.out.println("Tao customer " + customer.getId());
        return customer.getId();
    }

    @Transactional
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
        Outbox outbox = Outbox.createOutboxWithCustomer(customer, Operation.CustomerUpdated);
        outboxRepository.save(outbox);
    }

    @Transactional
    public void deleteCustomer(Customer customer) {
        Outbox outbox = Outbox.createOutboxWithCustomer(customer, Operation.CustomerDeleted);
        outboxRepository.save(outbox);
        customerRepository.delete(customer);
    }
}
