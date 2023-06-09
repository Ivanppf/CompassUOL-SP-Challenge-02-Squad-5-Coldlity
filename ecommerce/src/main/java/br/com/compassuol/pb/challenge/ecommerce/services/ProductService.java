package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.entities.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    public List<Product> findAllProducts();

    public Product saveProduct(Product productProps);

    public ResponseEntity<Product> findProductById(int productId);

    public Product updateProductById(int productId, Product productProps);

    public ResponseEntity<Object> deleteProductById(int productId);
}
