package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.entities.Customer;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    public ResponseEntity<Customer> findById(int id);

    public Customer saveCustomer(Customer customer);

    public Customer updateCustomer(int id, Customer customer);
}
