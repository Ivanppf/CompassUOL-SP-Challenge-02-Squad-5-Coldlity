package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.entities.Product;
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
        Float price = productProps.getPrice();
        String description = productProps.getDescription();

        return productRepository.save(new Product(name, price, description));
    }

    @Override
    public Optional<Product> findOneProduct(int id) {
        return productRepository.findById(id);
    }

    @Override
    public ResponseEntity<String> updateProductById(int id, Product productProps) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productProps.getName());
            product.setPrice(productProps.getPrice());
            product.setDescription(productProps.getDescription());

            productRepository.save(product);

            return ResponseEntity.status(HttpStatus.OK).body("PRODUTO " + id + " ATUALIZADO COM SUCESSO");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PRODUTO " + id + " NÃO ENCONTRADO");
        }
    }

    @Override
    public ResponseEntity<Object> deleteProductById(int id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            productRepository.deleteById(id);

            return ResponseEntity.status(HttpStatus.OK).body("PRODUTO " + id + " EXCLUIDO COM SUCESSO");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PRODUTO " + id + " NÃO ENCONTRADO");
        }
    }
}
