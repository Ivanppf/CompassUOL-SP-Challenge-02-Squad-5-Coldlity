package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.entities.Customer;
import br.com.compassuol.pb.challenge.ecommerce.exceptions.CustomerExceptions;
import br.com.compassuol.pb.challenge.ecommerce.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEntity<Customer> getCustomerById(int customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);

        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return ResponseEntity.ok(customer);
        } else {
            throw new CustomerExceptions.CustomerNotFoundException("CUSTOMER ID (" + customerId + ") NÃO ENCONTRADO");
        }
    }

    @Override
    public Customer saveCustomer(Customer customer){
        String name = customer.getName();
        String cpf = customer.getCpf();
        String email = customer.getEmail();
        boolean active = customer.isActive();

        return customerRepository.save(new Customer(name, cpf, email, active));
    }

    @Override
    public Customer updateCustomer(int customerId, Customer customerProps){
        Optional<Customer> customerOptional = customerRepository.findById(customerId);

        if(customerOptional.isPresent()){
            Customer customers = customerOptional.get();

            String name = customerProps.getName();
            String cpf = customerProps.getCpf();
            String email = customerProps.getEmail();

             String nameSanitized = name.trim();
            String cpfSanitized = cpf.trim();
            String emailSanitized = email.trim();

            if (nameSanitized == null || nameSanitized == "" || nameSanitized.length() < 3) {
                throw new CustomerExceptions.CustomerNameException("O ATRIBUTO NAME ESTÁ COM ALGUM PROBLEMA - ELE NÃO PODE SER NULO OU VAZIO E DEVE TER NO MINIMO 3 CARACTERES");
            } else if (cpfSanitized == null || cpfSanitized == "") {
                throw new CustomerExceptions.CustomerCpfException("O ATRIBUTO CPF ESTÁ COM ALGUM PROBLEMA - ELE NÃO PODE SER NULO OU VAZIO");
            } else if (emailSanitized == null || emailSanitized == "") {
                throw new CustomerExceptions.CustomerEmailException("O ATRIBUTO EMAIL ESTÁ COM ALGUM PROBLEMA - ELE NÃO PODE SER NULO OU VAZIO");
            }

            customers.setName(customerProps.getName());
            customers.setCpf(customerProps.getCpf());
            customers.setEmail(customerProps.getEmail());
            customers.setActive(customerProps.isActive());

            return customerRepository.save(customers);
        } else{
            throw new CustomerExceptions.CustomerNotFoundException("CUSTOMER ID (" + customerId + ") NÃO ENCONTRADO");
        }
    }

}
