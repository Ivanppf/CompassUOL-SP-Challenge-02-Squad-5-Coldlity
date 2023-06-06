package br.com.compassuol.pb.challenge.ecommerce.repositories;

import br.com.compassuol.pb.challenge.ecommerce.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
