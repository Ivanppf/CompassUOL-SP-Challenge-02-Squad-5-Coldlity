package br.com.compassuol.pb.challenge.ecommerce.entities;

import br.com.compassuol.pb.challenge.ecommerce.enums.StatusOptions;
import org.hibernate.engine.spi.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void setOrderId() {
        Order order =  new Order();
        Integer activeId = 1;
        order.setOrderId(activeId);
        assertEquals( 1, order.getOrderId());
    }

    @Test
    void getCustomer() {
        Order order =  new Order();
        Customer orderCustomer = order.getCustomer();
        assertNull(orderCustomer);
    }

    @Test
    void setCustomer() {
        Order order =  new Order();
        Customer customer = new Customer();
        order.setCustomer(customer);
        assertEquals( customer, order.getCustomer());
    }

    @Test
    void getDate() {
        Order order =  new Order();
        LocalDate orderLocalDate = order.getDate();
        assertNull(orderLocalDate);
    }

    @Test
    void setDate() {
        Order order =  new Order();
        LocalDate orderDate = order.getDate();
        order.setDate(orderDate);
        assertEquals( orderDate, order.getCustomer());
    }

    @Test
    void getStatus() {
        Order order =  new Order();
        StatusOptions orderStatus = order.getStatus();
        assertNull(orderStatus);
    }

    @Test
    void setStatus() {
        Order order =  new Order();
        StatusOptions orderStatusOptions = order.getStatus();
        order.setStatus(orderStatusOptions);
        assertEquals( orderStatusOptions, order.getCustomer());
    }


    @Test
    void testToString() {
        Order order =  new Order();
        String orderString = order.toString();
        assertEquals("Order{" +
                "orderId=" + null +
                ", customerId=" + null +
                ", date=" + null +
                ", status=" + null +
                '}', orderString);

    }


}