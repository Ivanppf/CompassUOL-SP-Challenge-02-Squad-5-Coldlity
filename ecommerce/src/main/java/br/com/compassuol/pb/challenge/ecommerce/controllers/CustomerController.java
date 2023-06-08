package br.com.compassuol.pb.challenge.ecommerce.controllers;

import java.util.Optional;

import br.com.compassuol.pb.challenge.ecommerce.entities.Customer;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.compassuol.pb.challenge.ecommerce.exceptions.CustomerNotFoundException;
import br.com.compassuol.pb.challenge.ecommerce.services.CustomerService;

@RestController
public class CustomerController {

    private CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    //Endpoint to GET the product by id
    @GetMapping("/v1/customers/{customerId}")
    public ResponseEntity<br.com.compassuol.pb.challenge.ecommerce.entities.Customer.Customer> getCustomer(@PathVariable int customerId){
        
        Optional<br.com.compassuol.pb.challenge.ecommerce.entities.Customer.Customer> customerOptional = customerService.findById(customerId);

        if (customerOptional.isPresent()) {
            br.com.compassuol.pb.challenge.ecommerce.entities.Customer.Customer product = customerOptional.get();
            return ResponseEntity.ok(product);
        } else {
            throw new CustomerNotFoundException("Id Not Found:" + customerId);
        }
    }

    
    @PostMapping("/v1/customers")
    public br.com.compassuol.pb.challenge.ecommerce.entities.Customer.Customer addCustomer(@RequestBody br.com.compassuol.pb.challenge.ecommerce.entities.Customer.Customer customer){
        return customerService.saveCustomer(customer);
    }


    
    @PutMapping("/v1/customers/{customerId}")
    public br.com.compassuol.pb.challenge.ecommerce.entities.Customer.Customer updateCustomer(@PathVariable int customerId, @RequestBody Customer.Customer product){
        return customerService.updateCustomer(customerId, product);
    }

}
