package br.com.compassuol.pb.challenge.ecommerce.repositories;

import br.com.compassuol.pb.challenge.ecommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
