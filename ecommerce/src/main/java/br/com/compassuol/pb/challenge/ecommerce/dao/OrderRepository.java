package br.com.compassuol.pb.challenge.ecommerce.dao;

import br.com.compassuol.pb.challenge.ecommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
