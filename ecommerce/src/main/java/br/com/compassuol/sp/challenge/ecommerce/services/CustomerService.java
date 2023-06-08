package br.com.compassuol.sp.challenge.ecommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compassuol.sp.challenge.ecommerce.entities.Customer;
import br.com.compassuol.sp.challenge.ecommerce.repositories.CustomerRepository;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

}
