package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.entities.Customer;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    public ResponseEntity<Customer> getCustomerById(int customerId);

    public Customer saveCustomer(Customer customerProps);

    public Customer updateCustomer(int customerId, Customer customerProps);
}
