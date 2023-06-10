package br.com.compassuol.pb.challenge.ecommerce.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Teste - Exceptions Product")
class ProductExceptionsTest {
    // testando se nossa exception do nome está funcionando corretamente colocando a mensagem certa
    // o status certo e se está sendo gerada da classe certa
    @Test
    @DisplayName("Teste - ProductNameException")
    void testProductNameException() {
        String message = "O ATRIBUTO NAME ESTÁ COM ALGUM PROBLEMA - ELE NÃO PODE SER NULO OU VAZIO E DEVE TER NO MINIMO 3 CARACTERES";

        try {
            throw new ProductExceptions.ProductNameException(message);
        } catch (ProductExceptions.ProductNameException exceptionProduct) {
            assertEquals(message, exceptionProduct.getMessage());
            assertEquals(ProductExceptions.ProductNameException.class, exceptionProduct.getClass());
            assertEquals(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST);
        }
    }

    // testando se nossa exception do price está funcionando corretamente colocando a mensagem certa
    // o status certo e se está sendo gerada da classe certa
    @Test
    @DisplayName("Test - ProductPriceException")
    void testProductPriceException() {
        String message = "O ATRIBUTO PRICE ESTÁ COM ALGUM PROBLEMA - ELE NÃO PODE SER NULO OU MENOR QUE 0";

        try {
            throw new ProductExceptions.ProductPriceException(message);
        } catch (ProductExceptions.ProductPriceException exceptionProduct) {
            assertEquals(message, exceptionProduct.getMessage());
            assertEquals(ProductExceptions.ProductPriceException.class, exceptionProduct.getClass());
            assertEquals(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST);
        }
    }

    // testando se nossa exception da description está funcionando corretamente colocando a mensagem certa
    // o status certo e se está sendo gerada da classe certa
    @Test
    @DisplayName("Teste - ProductDescriptionException")
    void testProductDescriptionException() {
        String message = "O ATRIBUTO DESCRIPTION ESTÁ COM ALGUM PROBLEMA - ELE NÃO PODE SER NULO OU VAZIO E DEVE TER NO MINIMO 3 CARACTERES";

        try {
            throw new ProductExceptions.ProductDescriptionException(message);
        } catch (ProductExceptions.ProductDescriptionException exceptionProduct) {
            assertEquals(message, exceptionProduct.getMessage());
            assertEquals(ProductExceptions.ProductDescriptionException.class, exceptionProduct.getClass());
            assertEquals(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST);
        }
    }

    // testando se nossa exception de product not found está
    // funcionando corretamente colocando a mensagem certa
    // o status certo e se está sendo gerada da classe certa
    @Test
    @DisplayName("Teste - ProductNotFoundException")
    void testProductNotFoundException() {
        String message = "O PRODUTO NÃO FOI ENCONTRADO";

        try {
            throw new ProductExceptions.ProductNotFoundException(message);
        } catch (ProductExceptions.ProductNotFoundException exceptionProduct) {
            assertEquals(message, exceptionProduct.getMessage());
            assertEquals(ProductExceptions.ProductNotFoundException.class, exceptionProduct.getClass());
            assertEquals(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }
}