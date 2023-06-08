package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.entities.Customer;
import br.com.compassuol.pb.challenge.ecommerce.entities.Order;
import br.com.compassuol.pb.challenge.ecommerce.exceptions.CustomerExceptions;
import br.com.compassuol.pb.challenge.ecommerce.repositories.CustomerRepository;
import br.com.compassuol.pb.challenge.ecommerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    // Repositories
    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;

    // constructor - inject dependency's
    @Autowired
    public OrderServiceImpl(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    // return all Orders
    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    // returning orders from a specific customer
    @Override
    public Order findOrdersById(int customerId) {
        Optional<Order> result = orderRepository.findById(customerId);
        if (result.isPresent())
            return result.get();
        throw new RuntimeException("Id não encontrado");
    }

    // save 1 order
    @Override
    public Order saveOrder(Order orderProps) {
        Optional<Customer> customerOptional = customerRepository.findById(orderProps.getCustomerId());

        if (customerOptional.isPresent()) {
            return orderRepository.save(orderProps);
        } else {
            throw new CustomerExceptions.CustomerNotFoundException("CUSTOMER ID (" + orderProps.getCustomerId() + ") NÃO ENCONTRADO");
        }
    }
}
