package br.com.compassuol.sp.challenge.ecommerce.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.compassuol.sp.challenge.ecommerce.entities.Customer;
import br.com.compassuol.sp.challenge.ecommerce.entities.CustomerNotFoundException;
import br.com.compassuol.sp.challenge.ecommerce.services.CustomerService;

@RestController
public class CustomerController {

    private CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    //Endpoint to GET the product by id
    @GetMapping("/v1/customers/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int customerId){
        
        Optional<Customer> customerOptional = customerService.findById(customerId);

        if (customerOptional.isPresent()) {
            Customer product = customerOptional.get();
            return ResponseEntity.ok(product);
        } else {
            throw new CustomerNotFoundException("Id Not Found:" + customerId);
        }
    }

}