package br.com.compassuol.pb.challenge.ecommerce.controllers;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import br.com.compassuol.pb.challenge.ecommerce.entities.Customer;
import br.com.compassuol.pb.challenge.ecommerce.services.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CustomerRestControllerTest {

    @InjectMocks
    private CustomerController customerRestController;

    @Mock
    private CustomerServiceImpl customerServiceImpl;
    private ResponseEntity<Customer> respostaCustomer;
    
    private Customer customerProps;

    @BeforeEach
    void setup(){
        customerProps = new Customer("gabriel","12345678910","gabriel@gmail.com",true);
        respostaCustomer = customerServiceImpl.getCustomerById(1);
    }

    @Test
    void testAddCustomer() {
        var response = assertDoesNotThrow(() -> customerRestController.addCustomer(customerProps));
        assertEquals(customerServiceImpl.saveCustomer(customerProps), response);
    }

    @Test
    void testGetCustomer() {
       
        when(customerServiceImpl.getCustomerById(1)).thenReturn(respostaCustomer);
        var response = assertDoesNotThrow(() -> customerRestController.getCustomerById(1));
        assertEquals(respostaCustomer,response);
    }

    @Test
    void testUpdateCustomer() {
        var response = assertDoesNotThrow(() -> customerRestController.updateCustomer(1,customerProps));
        assertEquals(customerServiceImpl.updateCustomer(1,customerProps), response);
    }

}
