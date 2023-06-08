package br.com.compassuol.sp.challenge.ecommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compassuol.sp.challenge.ecommerce.entities.Customer;
import br.com.compassuol.sp.challenge.ecommerce.entities.CustomerNotFoundException;
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

    public Customer saveCustomer(Customer customer){
        String name = customer.getName();
        String cpf = customer.getCpf();
        String email = customer.getEmail();
        boolean active = customer.isActive();

        Customer result = customerRepository.save(new Customer(name, cpf, email, active));
        return result;
    }

    public Customer updateCustomer(int id, Customer customer){
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if(customerOptional.isPresent()){
            Customer customers = customerOptional.get();
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
