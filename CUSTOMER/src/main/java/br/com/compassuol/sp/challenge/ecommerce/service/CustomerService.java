package br.com.compassuol.sp.challenge.ecommerce.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compassuol.sp.challenge.ecommerce.jpa.CustomerRepository;
import br.com.compassuol.sp.challenge.ecommerce.entity.Customer;

@Service
public class CustomerService {
    
    private CustomerRepository customerRepository;
    
    //constructor
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //method GET to find the Customer by id
    public Optional<Customer> findById(int id){
        return customerRepository.findById(id);
    }

}
