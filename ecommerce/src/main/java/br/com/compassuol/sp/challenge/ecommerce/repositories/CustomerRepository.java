package br.com.compassuol.sp.challenge.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.compassuol.sp.challenge.ecommerce.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
