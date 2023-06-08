package br.com.compassuol.pb.challenge.ecommerce.controllers;


import br.com.compassuol.pb.challenge.ecommerce.entities.Product;
import br.com.compassuol.pb.challenge.ecommerce.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProductRestController {
    // service
    private ProductServiceImpl service;

    // constructor - inject service dependency
    @Autowired
    public ProductRestController(ProductServiceImpl service) {
        this.service = service;
    }

    // return all products
    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.findAllProducts();
    }

    // create 1 product
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product productProps) {
        return service.saveProduct(productProps);
    }

    // return 1 product (search id)
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
        return service.findProductById(productId);
    }

    // update 1 product (search id)
    @PutMapping("/products/{id}")
    public Product updateProductById(@PathVariable int productId, @RequestBody Product productProps) {
        return service.updateProductById(productId, productProps);
    }

    // delete 1 product
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProductById(@PathVariable int productId) {
        return service.deleteProductById(productId);
    }
}