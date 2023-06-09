package br.com.compassuol.pb.challenge.ecommerce.controllers;

import br.com.compassuol.pb.challenge.ecommerce.entities.Customer;
import br.com.compassuol.pb.challenge.ecommerce.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class CustomerRestController {
    // service
    private CustomerServiceImpl customerServiceImpl;

    // constructor - inject service dependency
    @Autowired
    public CustomerRestController(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }

    // return 1 product (search id)
    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int customerId){
        return customerServiceImpl.findCustomerById(customerId);
    }

    // create 1 customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customerProps){
        return customerServiceImpl.saveCustomer(customerProps);
    }

    // update 1 product (search id)
    @PutMapping("/customers/{customerId}")
    public Customer updateCustomer(@PathVariable int customerId, @RequestBody Customer customerProps){
        return customerServiceImpl.updateCustomer(customerId, customerProps);
    }
}