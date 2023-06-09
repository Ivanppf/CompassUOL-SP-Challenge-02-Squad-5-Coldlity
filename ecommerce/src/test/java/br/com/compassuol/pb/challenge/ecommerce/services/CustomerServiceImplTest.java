package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.entities.Customer;
import br.com.compassuol.pb.challenge.ecommerce.repositories.CustomerRepository;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService = new CustomerServiceImpl(customerRepository);

    @Test
    void findCustomerById() {

        Customer customer = new Customer();
        when (customerRepository.findById(1)).thenReturn(Optional.of(customer));
        ResponseEntity<Customer> foundCustomer = customerService.findCustomerById(1);
        assertThat(foundCustomer).isNotNull();
        verify(customerRepository).findById(1);









//        verify(customerRepository).findById(null);
//        assertEquals(customerService, customerService);




//        List<Customer> optCustomer = new ArrayList<>();
//        Integer customerId = 1;
//        optCustomer.get(customerId);
//        assertEquals( null, customerId);





//                (
//
//                new Customer("Paulo", "123.456.789-10", "Paulo@gmail.com", true),
//                new Customer("Gabriel", "133.436.739-10", "Gabriel@gmail.com", true),
//                new Customer("Messi", "113.416.719-10", "Messi@gmail.com", true)
//        );
//        when(customerService.findCustomerById(1)).thenReturn();
//        assertEquals( false, optCustomer);



//        Optional<Optional<Customer>> customersGet = Optional.of(customerService.findById());
//        boolean customerTesGet = customersGet.equals(true);

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