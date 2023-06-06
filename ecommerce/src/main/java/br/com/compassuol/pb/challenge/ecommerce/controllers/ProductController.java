package br.com.compassuol.pb.challenge.ecommerce.controllers;

import br.com.compassuol.pb.challenge.ecommerce.entities.ProductEntity;
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
    public List<ProductEntity> getProducts() {
        return service.findAll();
    }

    // return 1 product (search id)
    @GetMapping("/v1/products/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable int id) {
        Optional<ProductEntity> productOptional = service.findOne(id);

        if (productOptional.isPresent()) {
            ProductEntity product = productOptional.get();
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
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
