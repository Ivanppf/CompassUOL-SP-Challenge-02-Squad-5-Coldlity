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
class ProductControllerTest {
    @Mock
    private ProductServiceImpl productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Teste - Retornando todos os Products")
    void testGetProductsListController() {
        List<Product> products = Arrays.asList(
                new Product("Produto TESTE 1", 100.99f, "Produto TESTE 1"),
                new Product("Produto TESTE 2", 5.75f, "Produto TESTE 2"),
                new Product("Produto TESTE 3", 9.99f, "Produto TESTE 3")
        );

        when(productService.findAllProducts()).thenReturn(products);

        List<Product> listProducts = productController.getProducts();

        assertEquals("Produto TESTE 1", listProducts.get(0).getName());
        assertEquals("Produto TESTE 2", listProducts.get(1).getName());
        assertEquals("Produto TESTE 3", listProducts.get(2).getName());

        assertEquals("Produto TESTE 1", listProducts.get(0).getDescription());
        assertEquals("Produto TESTE 2", listProducts.get(1).getDescription());
        assertEquals("Produto TESTE 3", listProducts.get(2).getDescription());

        assertEquals(100.99f, listProducts.get(0).getPrice());
        assertEquals(5.75f, listProducts.get(1).getPrice());
        assertEquals(9.99f, listProducts.get(2).getPrice());

        assertEquals(3, listProducts.size());
    }

    @Test
    @DisplayName("Teste - Atualizando um Product controller")
    void testUpdateProductByIdOkController() {
        int productId = 1;

        Product product = new Product("Produto TESTE 1", 100.99f, "Produto TESTE 1");
        Product productNewProps = new Product("Produto TESTE 1 - PUT", 199.99f, "Produto TESTE 1 - PUT");

        when(productService.updateProductById(productId, product)).thenReturn(productNewProps);

        Product newProduct = productController.updateProductById(productId, product);

        verify(productService).updateProductById(productId, product);
        assertEquals(productNewProps, newProduct);
    }

    @Test
    @DisplayName("Teste - Lançando Not Found Exception tentando atualizar um Product")
    void testUpdateProductByIdNotFoundExceptionController() {
        int productId = 1;

        Product productNewProps = new Product("Produto TESTE 1 - PUT", 199.99f, "Produto TESTE 1 - PUT");

        when(productService.updateProductById(productId, productNewProps)).thenThrow(new ProductExceptions.ProductNotFoundException("PRODUCT ID (" + productId + ") NÃO ENCONTRADO"));

        assertThrows(ProductExceptions.ProductNotFoundException.class, () -> {
            productController.updateProductById(productId, productNewProps);
        });
    }

    @Test
    @DisplayName("Teste - Deletando um Product")
    void testDeleteProductByIdOkController() {
        int productId = 1;

        ResponseEntity<Object> confirmedDeletion = ResponseEntity.status(HttpStatus.OK).body("PRODUTO ID (" + productId + ") EXCLUIDO COM SUCESSO");

        when(productService.deleteProductById(productId)).thenReturn(confirmedDeletion);

        ResponseEntity<Object> expectedAnswer = productController.deleteProductById(productId);

        verify(productService).deleteProductById(productId);
        assertEquals("PRODUTO ID (" + productId + ") EXCLUIDO COM SUCESSO", expectedAnswer.getBody());
        assertEquals(HttpStatus.OK, expectedAnswer.getStatusCode());
    }

    @Test
    @DisplayName("Teste - Lançando Not Found Exception tentando deletar um Product")
    void testDeleteProductByIdNotFoundExceptionController() {
        int productId = 1;

        when(productService.deleteProductById(productId)).thenThrow(new ProductExceptions.ProductNotFoundException("PRODUCT ID (" + productId + ") NÃO ENCONTRADO"));

        assertThrows(ProductExceptions.ProductNotFoundException.class, () -> {
            productController.deleteProductById(productId);
        });
    }

    @Test
    void testAddProductController() {
        Product productProps = new Product("Produto TESTE 1", 100.99f, "Produto TESTE 1");
        Product productAdded = new Product("Produto TESTE 1", 100.99f, "Produto TESTE 1");

        when(productService.saveProduct(productProps)).thenReturn(productAdded);

        Product expectedAnswer = productController.addProduct(productProps);

        verify(productService).saveProduct(productProps);
        assertEquals(productAdded.getName(), expectedAnswer.getName());
        assertEquals(productAdded.getDescription(), expectedAnswer.getDescription());
        assertEquals(productAdded.getPrice(), expectedAnswer.getPrice());
    }
}