package br.com.compassuol.pb.challenge.ecommerce.controllers;

import br.com.compassuol.pb.challenge.ecommerce.entities.Product;
import br.com.compassuol.pb.challenge.ecommerce.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProductController {
    private ProductServiceImpl service;

    @Autowired
    public ProductController(ProductServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.findAllProducts();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product productProps) {
        return service.saveProduct(productProps);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
        return service.findProductById(productId);
    }

    @PutMapping("/products/{productId}")
    public Product updateProductById(@PathVariable int productId, @RequestBody Product productProps) {
        return service.updateProductById(productId, productProps);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Object> deleteProductById(@PathVariable int productId) {
        return service.deleteProductById(productId);
    }
}