package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.entities.Order;

import java.util.List;
public interface OrderService {

    public List<Order> findAll();

    public Order findById(int id);

    public Order save(Order order);

    public void deleteById(int id);

}