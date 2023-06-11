package br.com.compassuol.pb.challenge.ecommerce.controllers;

import br.com.compassuol.pb.challenge.ecommerce.entities.Product;
import br.com.compassuol.pb.challenge.ecommerce.services.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ProductRestControllerTest {
    // Instância simulada do ProductServiceImpl
    @Mock
    private ProductServiceImpl productService;

    // Injetando o nosso Mock do Service no nosso Controller
    @InjectMocks
    private ProductRestController productController;

    // Antes de cada teste isso será executado
    // Inicia os Mocks e injeta eles onde temo @InjectMocks
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Teste - Retornando todos os products")
    void getProductsList() {
        // Lista de produtos simulando aqueles que estão cadastrados no banco
        List<Product> products = Arrays.asList(
                new Product("Produto TESTE 1", 100.99f, "Produto TESTE 1"),
                new Product("Produto TESTE 2", 5.75f, "Produto TESTE 2"),
                new Product("Produto TESTE 3", 9.99f, "Produto TESTE 3")
        );

        // Configurando o retorno da nossa chamado do método
        // do service que busca os products, neste caso ele irá
        // retornar a lista acima
        when(productService.findAllProducts()).thenReturn(products);

        // Chamando o método de fato
        List<Product> listProducts = productController.getProducts();

        // Verificações de name
        assertEquals("Produto TESTE 1", listProducts.get(0).getName());
        assertEquals("Produto TESTE 2", listProducts.get(1).getName());
        assertEquals("Produto TESTE 3", listProducts.get(2).getName());

        // Verificações de description
        assertEquals("Produto TESTE 1", listProducts.get(0).getDescription());
        assertEquals("Produto TESTE 2", listProducts.get(1).getDescription());
        assertEquals("Produto TESTE 3", listProducts.get(2).getDescription());

        // Verificações de price
        assertEquals(100.99f, listProducts.get(0).getPrice());
        assertEquals(5.75f, listProducts.get(1).getPrice());
        assertEquals(9.99f, listProducts.get(2).getPrice());

        // Verificando o tamanho da lista que foi retornado
        assertEquals(3, listProducts.size());
    }
}