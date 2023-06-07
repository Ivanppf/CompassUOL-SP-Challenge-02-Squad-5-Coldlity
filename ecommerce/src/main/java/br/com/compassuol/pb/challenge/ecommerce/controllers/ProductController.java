package br.com.compassuol.pb.challenge.ecommerce.controllers;


import br.com.compassuol.pb.challenge.ecommerce.entities.Product;
import br.com.compassuol.pb.challenge.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    // service
    private ProductService service;

    // inject service dependency
    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    // return all products
    @GetMapping("/v1/products")
    public List<Product> getProducts() {
        return service.findAll();
    }

    // create 1 product
    @PostMapping("/v1/products")
    public Product postProduct(@RequestBody Product productProps) {
        return service.saveProduct(productProps);
    }

    // return 1 product (search id)
    @GetMapping("/v1/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Optional<Product> productOptional = service.findOne(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/v1/products/{id}")
    public boolean putProductById(@PathVariable int id, @RequestBody Product productProps) {
        return service.updateProductById(id, productProps);
    }

    // delete 1 product
    @DeleteMapping("/v1/products/{id}")
    public ResponseEntity<Boolean> deleteProductById(@PathVariable int id) {
        boolean productDeleted = service.deleteById(id);

        if (productDeleted == true) {
            return ResponseEntity.ok(productDeleted);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}