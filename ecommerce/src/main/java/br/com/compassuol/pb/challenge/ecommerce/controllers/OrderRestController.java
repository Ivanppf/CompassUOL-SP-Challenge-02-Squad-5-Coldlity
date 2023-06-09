package br.com.compassuol.pb.challenge.ecommerce.controllers;

import br.com.compassuol.pb.challenge.ecommerce.entities.Order;
import br.com.compassuol.pb.challenge.ecommerce.services.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/v1")
public class OrderRestController {
    // Service
    private OrderServiceImpl orderService;

    // constructor - inject service dependency
    @Autowired
    public OrderRestController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    //get all orders
    @GetMapping(value = "/orders")
    public List<Order> findAll() {
        return orderService.findAllOrders();
    }

    // getting specific orders from a customer
    @GetMapping("/orders/customers/{customerId}")
    public List<Order> getOrderByCustomerId(@PathVariable int customerId) {
        return orderService.findOrdersByCustomerId(customerId);
    }

    // add Order
    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order orderProps) {
        Order anOrder = orderService.saveOrder(orderProps);
        return anOrder;
    }
}
