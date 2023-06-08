package br.com.compassuol.pb.challenge.ecommerce.controllers;


import br.com.compassuol.pb.challenge.ecommerce.entities.Product;
import br.com.compassuol.pb.challenge.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class ProductController {
    // service
    private ProductService service;

    // inject service dependency
    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    // return all products
    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.findAllProducts();
    }

    // create 1 product
    @PostMapping("/products")
    public Product postProduct(@RequestBody Product productProps) {
        return service.saveProduct(productProps);
    }

    // return 1 product (search id)
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Optional<Product> productOptional = service.findOneProduct(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<String> putProductById(@PathVariable int id, @RequestBody Product productProps) {
        return service.updateProductById(id, productProps);
    }

    // delete 1 product
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProductById(@PathVariable int id) {
        return service.deleteProductById(id);
    }
}