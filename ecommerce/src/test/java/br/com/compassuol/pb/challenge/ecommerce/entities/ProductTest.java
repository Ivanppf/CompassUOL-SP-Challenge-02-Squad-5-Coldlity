package br.com.compassuol.pb.challenge.ecommerce.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste - Entidade Product")
class ProductTest {
    private Product product;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product("PRODUTO TESTE", 299.99f, "PRODUTO TESTE");
    }

    @Test
    @DisplayName("Teste - Criação de um Product")
    public void testProductInit() {
        assertAll("Criação de um Product",
            // verificando se a instância de nosso objeto não é nula
            // ou seja, se ele criou o objeto
            () -> assertNotNull(product),

            // Neste caso ele irá ver se o getProductId() retorna 0
            // isso será verdadeiro pois o Id só é gerado depois que é inserido no banco
            // Então ele irá retornar null
            () -> assertEquals(null, product.getProductId()),

            // Testando pra ver se o name que nos demos na inicialização do objeto
            // Corresponde com o que foi salvo
            () -> assertEquals("PRODUTO TESTE", product.getName()),

            // Testando pra ver se a description que nos demos na inicialização do objeto
            // Corresponde com o que foi salvo
            () -> assertEquals("PRODUTO TESTE", product.getDescription()),


            // Testando pra ver se o price que nos demos na inicialização do objeto
            // Corresponde com o que foi salvo
            () -> assertEquals(299.99f, product.getPrice())
        );
    }

    @Test
    @DisplayName("Teste - Alterando dados de um Product")
    public void testProductUpdateInfos() {
        assertAll("Alterando dados de um Product",
            // verificando se a instância de nosso objeto não é nula
            // ou seja, se ele criou o objeto
            () -> assertNotNull(product),

            // Neste caso ele irá ver se o getProductId() retorna 0
            // isso será verdadeiro pois o Id só é gerado depois que é inserido no banco
            // Então ele irá retornar null
            () -> assertEquals(null, product.getProductId()),

            // Aqui estamos vendo se o update do campo name está
            // sendo feito corretamente
            () -> {
                String name = "TESTANDO SETTER NAME";
                product.setName(name);
                assertEquals("TESTANDO SETTER NAME", product.getName());
            },

            () -> {
                // Aqui estamos vendo se o update do campo description está
                // sendo feito corretamente
                String description = "TESTANDO SETTER DESCRIPTION";
                product.setDescription(description);
                assertEquals("TESTANDO SETTER DESCRIPTION", product.getDescription());
            },

            () -> {
                // Aqui estamos vendo se o update do campo price está
                // sendo feito corretamente
                float price = 100.99f;
                product.setPrice(price);
                assertEquals(100.99f, product.getPrice());
            }
        );
    }
}