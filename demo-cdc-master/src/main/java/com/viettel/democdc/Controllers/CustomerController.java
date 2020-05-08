package com.viettel.democdc.Controllers;

import com.viettel.democdc.Domain.Customer;
import com.viettel.democdc.Domain.RelyMessage;
import com.viettel.democdc.Services.CustomerService;
import com.viettel.democdc.Services.RelyMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private RelyMessageService relyMessageService;


    @PostMapping("/create")
    public int createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/update")
    public void updateCustomer(@RequestBody Customer customer) {
         customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete")
    public void deleteCustomer(@RequestBody Customer customer) {
        customerService.deleteCustomer(customer);
    }

    @GetMapping("/")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/newestrely")
    public RelyMessage getNewestRely() {
        List<RelyMessage> listRely = relyMessageService.getAllRely();
        System.out.println(listRely.size());
        return listRely.get(listRely.size()-1);
//        return "Msg from order";
    }

}
