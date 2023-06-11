package br.com.compassuol.pb.challenge.ecommerce.controllers;

import br.com.compassuol.pb.challenge.ecommerce.entities.Product;
import br.com.compassuol.pb.challenge.ecommerce.exceptions.ProductExceptions;
import br.com.compassuol.pb.challenge.ecommerce.services.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Teste - Controller Product")
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
    @DisplayName("Teste - Retornando todos os Products")
    void testGetProductsListController() {
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

    @Test
    @DisplayName("Teste - Atualizando um Product controller")
    void testUpdateProductByIdOkController() {
        int productId = 1;

        Product product = new Product("Produto TESTE 1", 100.99f, "Produto TESTE 1");
        Product productNewProps = new Product("Produto TESTE 1 - PUT", 199.99f, "Produto TESTE 1 - PUT");

        // Definindo o comportamento do service
        when(productService.updateProductById(productId, product)).thenReturn(productNewProps);

        // Chamando o método que será testado
        Product newProduct = productController.updateProductById(productId, product);

        // Verificando se as informações retornaram corretamente
        verify(productService).updateProductById(productId, product);
        assertEquals(productNewProps, newProduct);
    }

    @Test
    @DisplayName("Teste - Lançando Not Found Exception tentando atualizar um Product")
    void testUpdateProductByIdNotFoundExceptionController() {
        int productId = 1;

        Product productNewProps = new Product("Produto TESTE 1 - PUT", 199.99f, "Produto TESTE 1 - PUT");

        // Definindo que ao usarmos o método delete do nosso service ele irá
        // Retornar essa exception
        when(productService.updateProductById(productId, productNewProps)).thenThrow(new ProductExceptions.ProductNotFoundException("PRODUCT ID (" + productId + ") NÃO ENCONTRADO"));

        // Verificando se a exception foi lançada corretamente
        assertThrows(ProductExceptions.ProductNotFoundException.class, () -> {
            productController.updateProductById(productId, productNewProps);
        });
    }

    @Test
    @DisplayName("Teste - Deletando um Product")
    void testDeleteProductByIdOkController() {
        int productId = 1;

        // Nossa ResponseEntity que será retornada
        ResponseEntity<Object> confirmedDeletion = ResponseEntity.status(HttpStatus.OK).body("PRODUTO ID (" + productId + ") EXCLUIDO COM SUCESSO");

        // Definindo que o nosso service vai devolver a resposta ResponseEntity acima
        when(productService.deleteProductById(productId)).thenReturn(confirmedDeletion);

        // Chamando o método que será testado de fato
        ResponseEntity<Object> expectedAnswer = productController.deleteProductById(productId);

        // Verificando se as informações retornaram corretamente
        verify(productService).deleteProductById(productId);
        assertEquals("PRODUTO ID (" + productId + ") EXCLUIDO COM SUCESSO", expectedAnswer.getBody());
        assertEquals(HttpStatus.OK, expectedAnswer.getStatusCode());
    }

    @Test
    @DisplayName("Teste - Lançando Not Found Exception tentando deletar um Product")
    void testDeleteProductByIdNotFoundExceptionController() {
        int productId = 1;

        // Definindo que ao usarmos o método delete do nosso service ele irá
        // Retornar essa exception
        when(productService.deleteProductById(productId)).thenThrow(new ProductExceptions.ProductNotFoundException("PRODUCT ID (" + productId + ") NÃO ENCONTRADO"));

        // Verificando se a exception foi lançada corretamente
        assertThrows(ProductExceptions.ProductNotFoundException.class, () -> {
            productController.deleteProductById(productId);
        });
    }

    @Test
    void testAddProductController() {
        Product productProps = new Product("Produto TESTE 1", 100.99f, "Produto TESTE 1");
        Product productAdded = new Product("Produto TESTE 1", 100.99f, "Produto TESTE 1");

        // Definindo que nosso service irá retornar productAdded
        when(productService.saveProduct(productProps)).thenReturn(productAdded);

        // Chamando o método que será testado de fato
        Product expectedAnswer = productController.addProduct(productProps);

        // Verificando o retorno
        verify(productService).saveProduct(productProps);
        assertEquals(productAdded.getName(), expectedAnswer.getName());
        assertEquals(productAdded.getDescription(), expectedAnswer.getDescription());
        assertEquals(productAdded.getPrice(), expectedAnswer.getPrice());
    }
}