package br.com.compassuol.sp.challenge.ecommerce.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compassuol.sp.challenge.ecommerce.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    
}
