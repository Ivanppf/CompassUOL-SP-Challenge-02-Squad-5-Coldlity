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

import java.util.Arrays;
import java.util.List;

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
                new Product("Produto 1", 100.99f, "Produto 1"),
                new Product("Produto 2", 5.75f, "Produto 2"),
                new Product("Produto 3", 9.99f, "Produto 3")
        );

        // Definindo o comportamento do nosso método findAll do repository
        // Que é o método que nosso service chama quando usamos o findAllProducts
        // Neste caso estamos definindo que ele irá retornar products
        when(productRepository.findAll()).thenReturn(products);

        // Chamando o método de fato
        List<Product> listProducts = productService.findAllProducts();

        // Verificações de name
        assertEquals("Produto 1", listProducts.get(0).getName());
        assertEquals("Produto 2", listProducts.get(1).getName());
        assertEquals("Produto 3", listProducts.get(2).getName());

        // Verificações de description
        assertEquals("Produto 1", listProducts.get(0).getDescription());
        assertEquals("Produto 2", listProducts.get(1).getDescription());
        assertEquals("Produto 3", listProducts.get(2).getDescription());

        // Verificações de price
        assertEquals(100.99f, listProducts.get(0).getPrice());
        assertEquals(5.75f, listProducts.get(1).getPrice());
        assertEquals(9.99f, listProducts.get(2).getPrice());

        // Verificando o tamanho da lista que foi retornado
        assertEquals(3, listProducts.size());
    }
}