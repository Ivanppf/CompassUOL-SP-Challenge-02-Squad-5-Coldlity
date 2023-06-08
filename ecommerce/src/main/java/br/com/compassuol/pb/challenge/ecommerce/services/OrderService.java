package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.entities.Order;

import java.util.List;
public interface OrderService {

    public List<Order> findAllOrders();

    public Order findOrdersById(int id);

    public Order saveOrder(Order order);
}