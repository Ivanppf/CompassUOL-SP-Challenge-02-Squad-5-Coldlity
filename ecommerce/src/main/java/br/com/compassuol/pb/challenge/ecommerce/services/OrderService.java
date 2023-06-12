package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.dto.OrderDTO;
import br.com.compassuol.pb.challenge.ecommerce.entities.Order;

import java.util.List;

public interface OrderService {

    public List<Order> findAllOrders();

    public List<Order> findOrdersByCustomerId(int id);

    public Order saveOrder(OrderDTO order);
}