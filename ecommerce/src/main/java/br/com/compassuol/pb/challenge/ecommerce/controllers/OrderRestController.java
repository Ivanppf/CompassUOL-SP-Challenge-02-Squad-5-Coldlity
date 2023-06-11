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

    @GetMapping(value = "/orders")
    public List<Order> findAll() {
        return orderService.findAllOrders();
    }

    @GetMapping("/orders/customers/{customerId}")
    public List<Order> getOrderByCustomerId(@PathVariable int customerId) {
        return orderService.findOrdersByCustomerId(customerId);
    }

    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order orderProps) {
        Order anOrder = orderService.saveOrder(orderProps);
        return anOrder;
    }
}
