package br.com.compassuol.pb.challenge.ecommerce.controllers;

import br.com.compassuol.pb.challenge.ecommerce.entities.Order;
import br.com.compassuol.pb.challenge.ecommerce.services.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderRestControllerTest {
    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderServiceImpl orderServiceImpl;
    private List<Order> respostaOrder;

    private Order orderProps;

    @BeforeEach
    void setup(){
        orderProps = new Order();
        respostaOrder = orderServiceImpl.findOrdersByCustomerId(1);
    }

    @Test
    void findAll() {
        when(orderServiceImpl.findAllOrders()).thenReturn(respostaOrder);
        String response = assertDoesNotThrow(() -> orderController.findAll()).toString();
        assertEquals(respostaOrder,response);
    }

    @Test
    void getOrderByCustomerId() {
        when(orderServiceImpl.findOrdersByCustomerId(1)).thenReturn(respostaOrder);
        String response = assertDoesNotThrow(() -> orderController.getOrderByCustomerId(1)).toString();
        assertEquals(respostaOrder,response);
    }

//    @Test
//    void saveOrder() {
//        String response = assertDoesNotThrow(() -> orderController.saveOrder(1,orderProps));
//        assertEquals(orderServiceImpl.saveOrder(1,orderProps), response);
//    }
}