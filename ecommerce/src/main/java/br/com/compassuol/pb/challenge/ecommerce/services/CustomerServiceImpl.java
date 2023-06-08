package br.com.compassuol.pb.challenge.ecommerce.services;

import java.util.Optional;

import br.com.compassuol.pb.challenge.ecommerce.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.compassuol.pb.challenge.ecommerce.exceptions.CustomerNotFoundException;
import br.com.compassuol.pb.challenge.ecommerce.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<Customer> findById(int id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return ResponseEntity.ok(customer);
        } else {
            throw new CustomerNotFoundException("CUSTOMER ID (" + id + ") NÃO ENCONTRADO");
        }
    }

    public Customer saveCustomer(Customer customer){
        String name = customer.getName();
        String cpf = customer.getCpf();
        String email = customer.getEmail();
        boolean active = customer.isActive();

        String nameSanitized = name.trim();
        String cpfSanitized = cpf.trim();
        String emailSanitized = email.trim();

        return customerRepository.save(new Customer(name, cpf, email, active));
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
