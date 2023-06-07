package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.entities.Product;
import br.com.compassuol.pb.challenge.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
       return productRepository.findAll();
    }

    public Product saveProduct(Product productProps) {
        String name = productProps.getName();
        Float price = productProps.getPrice();
        String description = productProps.getDescription();

        Product savedProduct = productRepository.save(new Product(name, price, description));
        return savedProduct;
    }

    public Optional<Product> findOne(int id) {
        return productRepository.findById(id);
    }

    public boolean updateProductById(int id, Product productProps) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productProps.getName());
            product.setPrice(productProps.getPrice());
            product.setDescription(productProps.getDescription());

            productRepository.save(product);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteById(int id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
