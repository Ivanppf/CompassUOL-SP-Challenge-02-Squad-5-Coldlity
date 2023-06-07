package br.com.compassuol.pb.challenge.ecommerce.repositories;

import br.com.compassuol.pb.challenge.ecommerce.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
