package br.com.compassuol.pb.challenge.ecommerce.controllers;

import java.util.Optional;

import br.com.compassuol.pb.challenge.ecommerce.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.compassuol.pb.challenge.ecommerce.exceptions.CustomerNotFoundException;
import br.com.compassuol.pb.challenge.ecommerce.services.CustomerServiceImpl;

@RestController
public class CustomerController {
    private CustomerServiceImpl customerServiceImpl;

    @Autowired
    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }

    //Endpoint to GET the product by id
    @GetMapping("/v1/customers/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int customerId){
        return customerServiceImpl.findById(customerId);
    }

    @PostMapping("/v1/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerServiceImpl.saveCustomer(customer);
    }

    @PutMapping("/v1/customers/{customerId}")
    public Customer updateCustomer(@PathVariable int customerId, @RequestBody Customer customer){
        return customerServiceImpl.updateCustomer(customerId, customer);
    }
}
