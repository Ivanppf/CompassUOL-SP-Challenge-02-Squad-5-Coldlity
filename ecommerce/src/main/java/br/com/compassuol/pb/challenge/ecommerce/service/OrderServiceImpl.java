package br.com.compassuol.pb.challenge.ecommerce.service;



import br.com.compassuol.pb.challenge.ecommerce.entities.Order;
import br.com.compassuol.pb.challenge.ecommerce.dao.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
    @Override
    public Order findById(int id) {
        Optional<Order> result = orderRepository.findById(id);
        if (result.isPresent())
            return result.get();
        throw new RuntimeException("Id não encontrado");
    }
    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
    @Override
    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }
}
