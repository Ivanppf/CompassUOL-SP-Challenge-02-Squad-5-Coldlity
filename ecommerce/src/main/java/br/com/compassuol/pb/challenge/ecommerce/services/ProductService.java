package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.entities.ProductEntity;
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

    public List<ProductEntity> findAll() {
       return productRepository.findAll();
    }

    public ProductEntity saveProduct(ProductEntity productProps) {
        String name = productProps.getName();
        Float price = productProps.getPrice();
        String description = productProps.getDescription();

        ProductEntity savedProduct = productRepository.save(new ProductEntity(name, price, description));
        return savedProduct;
    }

    public Optional<ProductEntity> findOne(int id) {
        return productRepository.findById(id);
    }

    public boolean updateProductById(int id, ProductEntity productProps) {
        Optional<ProductEntity> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            ProductEntity product = productOptional.get();
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
        Optional<ProductEntity> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
