package br.com.compassuol.pb.challenge.ecommerce.controllers;

import br.com.compassuol.pb.challenge.ecommerce.entities.Order;
import br.com.compassuol.pb.challenge.ecommerce.services.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class OrderRestController {

    private OrderServiceImpl orderService;

    @Autowired
    public OrderRestController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    //get all orders
    @GetMapping("/orders")
    public List<Order> findAll() {
        return orderService.findAll();
    }

    //get specific order
    @GetMapping("/orders/{orderId}")
    public Order getOrder(@PathVariable int orderId) {
        Order order = orderService.findById(orderId);

        if (order == null)

            throw new RuntimeException("Order id not found - " + orderId);

        return order;
    }

    // add post method
    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order) {
        Order anOrder = orderService.save(order);
        return anOrder;
    }
}
