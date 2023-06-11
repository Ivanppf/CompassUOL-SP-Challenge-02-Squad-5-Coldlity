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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DisplayName("Teste - Service Product")
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
    @DisplayName("Teste - Buscando todos os produtos")
    void testFindAllProductsService() {
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
    void testProductInvalidNameExceptionThrowService() {
        // Product com o nome inválido
        Product productToBeSaved = new Product("Pr", 100.99f, "Produto TESTE 1");

        // Verificando se estamos lançando a exceção correta para esse tipo de problema
        assertThrows(ProductExceptions.ProductNameException.class, () -> {
            productService.saveProduct(productToBeSaved);
        });
    }

    @Test
    @DisplayName("Teste - Product com description inválida")
    void testProductInvalidDescriptionExceptionThrowService() {
        // Product com a description inválida
        Product productToBeSaved = new Product("Produto TESTE 1", 100.99f, "Pr");

        // Verificando se estamos lançando a exceção correta para esse tipo de problema
        assertThrows(ProductExceptions.ProductDescriptionException.class, () -> {
            productService.saveProduct(productToBeSaved);
        });
    }

    @Test
    @DisplayName("Teste - Product com price inválido")
    void testProductInvalidPriceExceptionThrowService() {
        // Product com o price inválido
        Product productToBeSaved = new Product("Produto TESTE 1", -1f, "Produto TESTE 1");

        // Verificando se estamos lançando a exceção correta para esse tipo de problema
        assertThrows(ProductExceptions.ProductPriceException.class, () -> {
            productService.saveProduct(productToBeSaved);
        });
    }

    @Test
    @DisplayName("Teste - Deletando um Product")
    void testDeleteProductByIdOkService() {
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
    @DisplayName("Teste - Tentando deletar um Product que não existe")
    void testDeleteProductByIdNotFoundService() {
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

    @Test
    @DisplayName("Teste - Atualizando um Product")
    void testUpdateProductByIdOkService() {
        int productId = 1;
        Product product = new Product("Produto TESTE 1", 100.99f, "Produto TESTE 1");

        // Definindo o comportamento do nosso método findById do repository
        // Que é um dos métodos usados pelo updateProductById para ver se o product existe
        // Neste estamos dizendo que ele irá retornar um Optional Product
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        // Aqui definimos que quando chamarmos nosso .save ele irá retornar um Product
        when(productRepository.save(any(Product.class))).thenReturn(product);

        String newName = "Produto TESTE 1 - PUT";
        float newPrice = 1000.99f;
        String newDescription = "Produto TESTE 1 - PUT";

        // Criando uma instância do nosso Product
        Product productNewProps = new Product(newName, newPrice, newDescription);

        // Chamando o método e passando nosso productId e os novos dados do Product
        Product productToBeSaved = productService.updateProductById(productId, productNewProps);

        // Verificando se as informações foram alteradas realmente
        assertEquals(newName, productToBeSaved.getName());
        assertEquals(newPrice, productToBeSaved.getPrice());
        assertEquals(newDescription, productToBeSaved.getDescription());
    }

    @Test
    @DisplayName("Teste - Tentando mudar os atributos de um produto que não existe")
    void testUpdateProductByIdNotFoundService() {
        int productId = 1;

        // Definindo o comportamento do nosso método findById do repository
        // Que é um dos métodos usados pelo updateProductById para ver se o product existe
        // Neste estamos dizendo que ele irá retornar um Optional vazio
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        String newName = "Produto TESTE 1 - PUT";
        float newPrice = 1000.99f;
        String newDescription = "Produto TESTE 1 - PUT";

        Product productNewProps = new Product(newName, newPrice, newDescription);

        // Verificando se a exception de Not Found é lançada corretamente
        assertThrows(ProductExceptions.ProductNotFoundException.class, () -> {
            productService.updateProductById(productId, productNewProps);
        });
    }
}