package br.com.compassuol.pb.challenge.ecommerce.controller;

import br.com.compassuol.pb.challenge.ecommerce.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class OrderRestController {

    private OrderService orderService;

    @Autowired
    public OrderRestController(OrderService orderService){
        this.orderService = orderService;
    }

    //get all orders
    @GetMapping("/orders")
    public List<Order> orders findAll(){
        return ordersService.findAll();
    }


    //get specific order

    @GetMapping("/orders/{orderId}")
    public Order getOrder(@PathVariable int orderId){

        Order order = orderService.findById(orderId);

        if(order == null)

            throw new RuntimeException("Employee id not found - " + orderId);

        return order;

    }


    // add post method

}
