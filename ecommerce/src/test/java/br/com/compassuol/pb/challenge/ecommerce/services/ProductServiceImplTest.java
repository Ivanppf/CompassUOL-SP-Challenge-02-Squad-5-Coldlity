package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.entities.Product;
import br.com.compassuol.pb.challenge.ecommerce.exceptions.ProductExceptions;
import br.com.compassuol.pb.challenge.ecommerce.repositories.ProductRepository;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductServiceImplTest {
    // Instância simulada do ProductRepository
    @Mock
    private ProductRepository productRepository;

    // Injetando o nosso Mock do Repository no nosso Service
    @InjectMocks
    private ProductService productService = new ProductServiceImpl(productRepository);

    // Antes de cada teste isso será executado
    // Inicia os Mocks e injeta eles onde temo @InjectMocks
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Buscando todos os Products - findAllProducts()")
    void testFindAllProducts() {
        // Lista de produtos simulando aqueles que estão cadastrados no banco
        List<Product> products = Arrays.asList(
                new Product("Produto TESTE 1", 100.99f, "Produto TESTE 1"),
                new Product("Produto TESTE 2", 5.75f, "Produto TESTE 2"),
                new Product("Produto TESTE 3", 9.99f, "Produto TESTE 3")
        );

        // Definindo o comportamento do nosso método findAll do repository
        // Que é o método que nosso service chama quando usamos o findAllProducts
        // Neste caso estamos definindo que ele irá retornar products
        when(productRepository.findAll()).thenReturn(products);

        // Chamando o método de fato
        List<Product> listProducts = productService.findAllProducts();

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
    @DisplayName("Teste - Product com name inválido")
    void testProductInvalidNameExceptionThrow() {
        // Product com o nome inválido
        Product productToBeSaved = new Product("Pr", 100.99f, "Produto TESTE 1");

        // Verificando se estamos lançando a exceção correta para esse tipo de problema
        assertThrows(ProductExceptions.ProductNameException.class, () -> {
            productService.saveProduct(productToBeSaved);
        });
    }

    @Test
    @DisplayName("Teste - Product com description inválida")
    void testProductInvalidDescriptionExceptionThrow() {
        // Product com a description inválida
        Product productToBeSaved = new Product("Produto TESTE 1", 100.99f, "Pr");

        // Verificando se estamos lançando a exceção correta para esse tipo de problema
        assertThrows(ProductExceptions.ProductDescriptionException.class, () -> {
            productService.saveProduct(productToBeSaved);
        });
    }

    @Test
    @DisplayName("Teste - Product com price inválido")
    void testProductInvalidPriceExceptionThrow() {
        // Product com o price inválido
        Product productToBeSaved = new Product("Produto TESTE 1", -1f, "Produto TESTE 1");

        // Verificando se estamos lançando a exceção correta para esse tipo de problema
        assertThrows(ProductExceptions.ProductPriceException.class, () -> {
            productService.saveProduct(productToBeSaved);
        });
    }

    @Test
    @DisplayName("Teste - Deletando um Product")
    void testDeleteProductByIdOk() {
        int productId = 1;

        // Definindo o comportamento do nosso método findById do repository
        // Que é um dos métodos usados pelo deleteProductById para ver se o product existe
        // Neste estamos dizendo que ele irá retornar um Optional do Product que estamos criando
        when(productRepository.findById(productId)).thenReturn(Optional.of(new Product("Produto TESTE 1", 100.99f, "Produto TESTES 1")));

        // Chamando o método de fato para testa-lo
        ResponseEntity<Object> response = productService.deleteProductById(productId);

        // Verificando se a resposta está sendo conforme planejamos
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("PRODUTO ID (1) EXCLUIDO COM SUCESSO", response.getBody());
    }

    @Test
    @DisplayName("Teste - Tentando deletar um produto que não existe")
    void testDeleteProductByIdNotFound() {
        int productId = 1;

        // Definindo o comportamento do nosso método findById do repository
        // Que é um dos métodos usados pelo deleteProductById para ver se o product existe
        // Neste estamos dizendo que ele irá retornar um Optional vazio
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        // Verificando se a resposta está sendo conforme planejamos, neste caso se a exception está correta
        assertThrows(ProductExceptions.ProductNotFoundException.class, () -> {
            productService.deleteProductById(productId);
        });
    }
}