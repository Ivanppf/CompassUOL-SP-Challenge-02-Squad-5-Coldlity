package br.com.compassuol.pb.challenge.ecommerce.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(value = MockitoExtension.class)
class CustomerTest {


//    @Test
//    void Customer(){
//        Customer customerContrutor = new Customer();
//
//        String construtor = "Paulo";
//        String construtor = "Paulo@gmail.com";
//        String construtor =
//        boolean construtor = customerContrutor.isActive();
//
//
//
//        this.name = name;
//        this.cpf = cpf;
//        this.email = email;
//        this.active = active;
//    }


    @Test
    void getCustomerId() {
        Customer customer =  new Customer();
        Integer customerId = customer.getCustomerId();
        assertNull(customerId);
    }

    @Test
    void setCustomerId() {
        Customer customer =  new Customer();
        Integer activeId = 1;
        customer.setCustomerId(activeId);
        assertEquals( 1, customer.getCustomerId());
    }

    @Test
    void getName() {
        Customer customer =  new Customer();
        String customerName = customer.getName();
        assertNull( customerName);
    }

    @Test
    void setName() {
        Customer customer =  new Customer();
        String activeName = "Paulo";
        customer.setName(activeName);
        assertEquals( "Paulo", customer.getName());
    }

    @Test
    void getCpf() {
        Customer customer =  new Customer();
        String customerCpf = customer.getCpf();
        assertEquals(  null, customerCpf);
    }

    @Test
    void setCpf() {
        Customer customer =  new Customer();
        String activeCpf = "123.456.789-10";
        customer.setCpf(activeCpf);
        assertEquals( "123.456.789-10", customer.getCpf());
    }

    @Test
    void getEmail() {
        Customer customer =  new Customer();
        String customerEmail = customer.getEmail();
        assertEquals(  null, customerEmail);
    }

    @Test
    void setEmail() {
        Customer customer =  new Customer();
        String activeEmail = "Paulo@gmail.com";
        customer.setEmail(activeEmail);
        assertEquals( "Paulo@gmail.com", customer.getEmail());
    }

    @Test
    void isActive() {
        Customer customer =  new Customer();
        Boolean customerBoll = customer.isActive();
        assertEquals(  false, customerBoll);
    }

    @Test
    void setActive() {
        Customer customer =  new Customer();
        boolean active = false;
        customer.setActive(active);
        assertEquals(  false, customer.isActive());
    }

    @Test
    void testToString() {
        Customer customer =  new Customer();
        String customerTest = customer.toString();
        assertEquals("Customer{" +
                "customerId=" + null +
                ", name='" + null + '\'' +
                ", cpf='" + null + '\'' +
                ", email='" + null + '\'' +
                ", active=" + false +
                '}', customerTest);
    }
}