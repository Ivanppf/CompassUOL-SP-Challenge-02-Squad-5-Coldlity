package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.entities.Customer;
import br.com.compassuol.pb.challenge.ecommerce.entities.Product;
import br.com.compassuol.pb.challenge.ecommerce.exceptions.CustomerExceptions;
import br.com.compassuol.pb.challenge.ecommerce.exceptions.ProductExceptions;
import br.com.compassuol.pb.challenge.ecommerce.repositories.CustomerRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService = new CustomerServiceImpl(customerRepository);

    @DisplayName("Teste GET customer by id")
    @Test
    void findCustomerById() {

        //criando o novo objeto que o mock irá retornar
        Customer customer = new Customer();
        // quando o repository receber uma chamada pra um findId de 1, retorna o objeto
        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
        //chama o metodo na classe que esta sendo testada
        ResponseEntity<Customer> foundCustomer = customerService.getCustomerById(1);
        //recebendo um objeto especial 
        assertThat(foundCustomer).isNotNull();
        //verifica se o metodo foi chamado
        verify(customerRepository).findById(1);
    }

    @DisplayName("Teste POST customer")
    @Test
    void SaveCustomer() {
        Customer customer = new Customer();
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        Customer savedCustomer = customerService.saveCustomer(new Customer());
        verify(customerRepository).save(any(Customer.class));
        assertThat(savedCustomer).isNotNull();
    }

    @DisplayName("Teste PUT customer")
    @Test
    void UpdateCustomer() {
        Customer customer = new Customer();

        customer.setCustomerId(1);
        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

        Customer updateCustomer = new Customer();

        updateCustomer.setName("Paulo");
        updateCustomer.setCpf("123456789");
        updateCustomer.setEmail("Paulo@gmail.com");
        updateCustomer.setActive(true);

        when(customerService.updateCustomer(1, updateCustomer)).thenReturn(updateCustomer);

        Customer updatedCustomer = customerService.updateCustomer(1, updateCustomer);

        verify(customerRepository).save(any(Customer.class));
        assertThat(updatedCustomer).isNotNull();
    }


    @Test
    @DisplayName("Teste - Tentando mudar os atributos de um produto que não existe")
    void testUpdateProductByIdNotFoundService() {
        int customerId = 1;

        // Definindo o comportamento do nosso método findById do repository
        // Que é um dos métodos usados pelo updateProductById para ver se o product existe
        // Neste estamos dizendo que ele irá retornar um Optional vazio
        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        String newName = "Gabriel";
        String newCpf = "123.456.7890-10";
        String newEmail = "Gabriel@gmail.com";
        boolean newActive = true;

        Customer customerNewProps = new Customer(newName, newCpf, newEmail, newActive);

        // Verificando se a exception de Not Found é lançada corretamente
        assertThrows(CustomerExceptions.CustomerNotFoundException.class, () -> {
            customerService.updateCustomer(customerId, customerNewProps);
        });
    }
}