package br.com.compassuol.pb.challenge.ecommerce.entities;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProductTest {
    private Product product;

    // Aqui instânciamos o ValidatorFactory que vai gerar nosso Validator
    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    // Nosso validator é responsável por validar os objetos com base nas anotações que usamos na Entity
    // E assim obter as violações encontradas etc
    private final Validator validator = validatorFactory.getValidator();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product("PRODUTO TESTE", 299.99f, "PRODUTO TESTE");
    }

    @Test
    public void testProductInit() {
        // verificando se a instância de nosso objeto não é nula
        // ou seja, se ele criou o objeto
        assertNotNull(product);

        // Neste caso ele irá ver se o getProductId() retorna 0
        // isso será verdadeiro pois o Id só é gerado depois que é inserido no banco
        // Então ele irá retornar null
        assertEquals(null, product.getProductId());

        // Testando pra ver se o name que nos demos na inicialização do objeto
        // Corresponde com o que foi salvo
        assertEquals("PRODUTO TESTE", product.getName());

        // Testando pra ver se a description que nos demos na inicialização do objeto
        // Corresponde com o que foi salvo
        assertEquals("PRODUTO TESTE", product.getDescription());

        // Testando pra ver se o price que nos demos na inicialização do objeto
        // Corresponde com o que foi salvo
        assertEquals(299.99f, product.getPrice());
    }

    @Test
    public void testProductUpdateInfos() {
        // verificando se a instância de nosso objeto não é nula
        // ou seja, se ele criou o objeto
        assertNotNull(product);

        // Neste caso ele irá ver se o getProductId() retorna 0
        // isso será verdadeiro pois o Id só é gerado depois que é inserido no banco
        // Então ele irá retornar null
        assertEquals(null, product.getProductId());

        // Aqui estamos vendo se o update do campo name está
        // sendo feito corretamente
        String name = "TESTANDO SETTER NAME";
        product.setName(name);
        assertEquals("TESTANDO SETTER NAME", product.getName());

        // Aqui estamos vendo se o update do campo description está
        // sendo feito corretamente
        String description = "TESTANDO SETTER DESCRIPTION";
        product.setDescription(description);
        assertEquals("TESTANDO SETTER DESCRIPTION", product.getDescription());

        // Aqui estamos vendo se o update do campo price está
        // sendo feito corretamente
        float price = 100.99f;
        product.setPrice(price);
        assertEquals(100.99f, product.getPrice());
    }
}