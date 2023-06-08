package br.com.compassuol.pb.challenge.ecommerce.services;

import java.util.Optional;

import br.com.compassuol.pb.challenge.ecommerce.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compassuol.pb.challenge.ecommerce.exceptions.CustomerNotFoundException;
import br.com.compassuol.pb.challenge.ecommerce.repositories.CustomerRepository;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<br.com.compassuol.pb.challenge.ecommerce.entities.Customer.Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    public br.com.compassuol.pb.challenge.ecommerce.entities.Customer.Customer saveCustomer(br.com.compassuol.pb.challenge.ecommerce.entities.Customer.Customer customer){
        String name = customer.getName();
        String cpf = customer.getCpf();
        String email = customer.getEmail();
        boolean active = customer.isActive();

        br.com.compassuol.pb.challenge.ecommerce.entities.Customer.Customer result = customerRepository.save(new br.com.compassuol.pb.challenge.ecommerce.entities.Customer.Customer(name, cpf, email, active));
        return result;
    }

    public br.com.compassuol.pb.challenge.ecommerce.entities.Customer.Customer updateCustomer(int id, br.com.compassuol.pb.challenge.ecommerce.entities.Customer.Customer customer){
        Optional<br.com.compassuol.pb.challenge.ecommerce.entities.Customer.Customer> customerOptional = customerRepository.findById(id);

        if(customerOptional.isPresent()){
            Customer.Customer customers = customerOptional.get();
            customers.setName(customer.getName());
            customers.setCpf(customer.getCpf());
            customers.setEmail(customer.getEmail());
            customers.setActive(customer.isActive());

            return  customerRepository.save(customers);
        }else{
            throw new CustomerNotFoundException("Id not found: " + id); 
        }
    }

}
