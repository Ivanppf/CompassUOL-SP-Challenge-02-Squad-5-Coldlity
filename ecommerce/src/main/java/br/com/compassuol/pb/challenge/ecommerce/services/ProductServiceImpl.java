package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.entities.Product;
import br.com.compassuol.pb.challenge.ecommerce.exceptions.ProductExceptions;
import br.com.compassuol.pb.challenge.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product productProps) {
        String name = productProps.getName();
        float price = productProps.getPrice();
        String description = productProps.getDescription();

        String nameSanitized = name.trim();
        String descriptionSanitized = description.trim();

        if (nameSanitized == null || nameSanitized == "" || nameSanitized.length() < 3) {
            throw new ProductExceptions.ProductNameException("O ATRIBUTO NAME ESTÁ COM ALGUM PROBLEMA - ELE NÃO PODE SER NULO OU VAZIO E DEVE TER NO MINIMO 3 CARACTERES");
        } else if (descriptionSanitized == null || descriptionSanitized == "" || descriptionSanitized.length() < 3) {
            throw new ProductExceptions.ProductDescriptionException("O ATRIBUTO DESCRIPTION ESTÁ COM ALGUM PROBLEMA - ELE NÃO PODE SER NULO OU VAZIO E DEVE TER NO MINIMO 3 CARACTERES");
        } else if (price < 0) {
            throw new ProductExceptions.ProductPriceException("O ATRIBUTO PRICE ESTÁ COM ALGUM PROBLEMA - ELE NÃO PODE SER NULO OU MENOR QUE 0");
        }

        return productRepository.save(new Product(nameSanitized, price, descriptionSanitized));
    }

    @Override
    public ResponseEntity<Product> findProductById(int productId) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return ResponseEntity.ok(product);
        } else {
            throw new ProductExceptions.ProductNotFoundException("PRODUCT ID (" + productId + ") NÃO ENCONTRADO");
        }
    }

    @Override
    public Product updateProductById(int productId, Product productProps) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            String name = productProps.getName();
            String description = productProps.getDescription();
            float price = productProps.getPrice();

            String nameSanitized = name.trim();
            String descriptionSanitized = description.trim();

            if (nameSanitized == null || nameSanitized == "" || nameSanitized.length() < 3) {
                throw new ProductExceptions.ProductNameException("O ATRIBUTO NAME ESTÁ COM ALGUM PROBLEMA - ELE NÃO PODE SER NULO OU VAZIO E DEVE TER NO MINIMO 3 CARACTERES");
            } else if (descriptionSanitized == null || descriptionSanitized == "" || descriptionSanitized.length() < 3) {
                throw new ProductExceptions.ProductDescriptionException("O ATRIBUTO DESCRIPTION ESTÁ COM ALGUM PROBLEMA - ELE NÃO PODE SER NULO OU VAZIO E DEVE TER NO MINIMO 3 CARACTERES");
            } else if (price < 0) {
                throw new ProductExceptions.ProductPriceException("O ATRIBUTO PRICE ESTÁ COM ALGUM PROBLEMA - ELE NÃO PODE SER NULO OU MENOR QUE 0");
            }

            product.setName(productProps.getName());
            product.setPrice(productProps.getPrice());
            product.setDescription(productProps.getDescription());

            return productRepository.save(product);
        } else {
            throw new ProductExceptions.ProductNotFoundException("PRODUCT ID (" + productId + ") NÃO ENCONTRADO");
        }
    }

    @Override
    public ResponseEntity<Object> deleteProductById(int productId) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            productRepository.deleteById(productId);

            return ResponseEntity.status(HttpStatus.OK).body("PRODUTO ID (" + productId + ") EXCLUIDO COM SUCESSO");
        } else {
            throw new ProductExceptions.ProductNotFoundException("PRODUCT ID (" + productId + ") NÃO ENCONTRADO");
        }
    }
}
