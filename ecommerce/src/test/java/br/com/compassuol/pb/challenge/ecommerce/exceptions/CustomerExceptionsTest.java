package br.com.compassuol.pb.challenge.ecommerce.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class CustomerExceptionsTest {

    @DisplayName("Testando a exception quando o customer não é encontrado")
    @Test
    void CustomerNotFoundException(){
        String message = "Customer Não Foi Encontrado";

        try{
            throw new CustomerExceptions.CustomerNotFoundException(message);
        }catch (CustomerExceptions.CustomerNotFoundException exceptionCustomer){
            assertEquals(message, exceptionCustomer.getMessage());            
            assertEquals(CustomerExceptions.CustomerNotFoundException.class, exceptionCustomer.getClass());
            assertEquals(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND);

        }
    }

    @DisplayName("Testando a exception de name")
    @Test
    void CustomerNameException(){

        String message = "Não Pode ser Nulo ou Vazio, e deve conter pelo menos 3 caracteres";

        try{
            throw new CustomerExceptions.CustomerNameException(message);
        }catch (CustomerExceptions.CustomerNameException exceptionCustomer){
            assertEquals(message, exceptionCustomer.getMessage());            
            assertEquals(CustomerExceptions.CustomerNameException.class, exceptionCustomer.getClass());
            assertEquals(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST);

        }
    }

    @DisplayName("Testando a exception do cpf")
    @Test
    void CustomerCpfException(){

        String message = "Não Pode ser Nulo ou Vazio";

        try{
            throw new CustomerExceptions.CustomerCpfException(message);
        }catch (CustomerExceptions.CustomerCpfException exceptionCustomer){
            assertEquals(message, exceptionCustomer.getMessage());            
            assertEquals(CustomerExceptions.CustomerCpfException.class, exceptionCustomer.getClass());
            assertEquals(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST);

        }
    }

    @DisplayName("Testando a exception do email")
    @Test
    void CustomerEmailException(){

        String message = "Não Pode ser Nulo ou Vazio";

        try{
            throw new CustomerExceptions.CustomerEmailException(message);
        }catch (CustomerExceptions.CustomerEmailException exceptionCustomer){
            assertEquals(message, exceptionCustomer.getMessage());            
            assertEquals(CustomerExceptions.CustomerEmailException.class, exceptionCustomer.getClass());
            assertEquals(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST);

        }
    }
}
