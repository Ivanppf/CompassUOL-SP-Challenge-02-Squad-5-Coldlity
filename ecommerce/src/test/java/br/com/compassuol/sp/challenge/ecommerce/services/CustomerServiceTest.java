package br.com.compassuol.sp.challenge.ecommerce.services;

import br.com.compassuol.sp.challenge.ecommerce.entities.Customer;
import br.com.compassuol.sp.challenge.ecommerce.repositories.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import javax.naming.Name;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    void findById(int id) {
        ArrayList<Customer> optCustomer = new ArrayList<Customer>();



        Optional<Optional<Customer>> customersGet = Optional.of(customerService.findById(id));
        boolean customerTesGet = customersGet.equals(true);

    }

//    @Test
//    @DisplayName("Deve verificar se está nulo")
//    void saveCustomerWinner() {
//        Optional<Optional<Customer>> customersGet = Optional.of(customerService.findById(id));
//        String customerName = String.valueOf(customer.getName());
//        String customerCpf = String.valueOf(customer.getCpf());
//        String customerEmail = String.valueOf(customer.getEmail());
//        boolean customerActive = customer.isActive();

//        assertEquals(null, customerName);
//        assertEquals(null, customerCpf);
//        assertEquals(null, customerEmail);
//        assertEquals( false, customerActive);
    //   }

//    @Test
//    void testVerificar() {
//        Optional<Optional<Customer>> customersGet = Optional.of(customerService.findById(id));
//        boolean verefica = customersGet.equals(true);
//        assertEquals( true, verefica);
//    }


//    @Test
//    void updateCustomer() {
//    }




}