package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.entities.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> findAllProducts();

    public Product saveProduct(Product productProps);

    public Optional<Product> findOneProduct(int id);

    public ResponseEntity<String> updateProductById(int id, Product productProps);

    public ResponseEntity<Object> deleteProductById(int id);
}
