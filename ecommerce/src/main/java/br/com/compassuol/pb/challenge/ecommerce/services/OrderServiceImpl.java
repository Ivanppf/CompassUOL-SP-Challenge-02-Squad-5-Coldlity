package br.com.compassuol.pb.challenge.ecommerce.services;



import br.com.compassuol.pb.challenge.ecommerce.entities.Customer;
import br.com.compassuol.pb.challenge.ecommerce.entities.Order;
import br.com.compassuol.pb.challenge.ecommerce.exceptions.CustomerExceptions;
import br.com.compassuol.pb.challenge.ecommerce.repositories.CustomerRepository;
import br.com.compassuol.pb.challenge.ecommerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findOrdersByCustomerId(int customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);

        if (customerOptional.isPresent()) {

            return orderRepository.findAllByCustomer_CustomerId(customerId);
        } else {
            throw new CustomerExceptions.CustomerNotFoundException("CUSTOMER ID (" + customerId + ") NÃO ENCONTRADO");
        }
    }

    @Override
    public Order saveOrder(Order orderProps) {
        int customerId = orderProps.getCustomer().getCustomerId();
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            return orderRepository.save(orderProps);
        } else {
            throw new CustomerExceptions.CustomerNotFoundException("CUSTOMER ID (" + customerId + ") NÃO ENCONTRADO");
        }
    }
}
