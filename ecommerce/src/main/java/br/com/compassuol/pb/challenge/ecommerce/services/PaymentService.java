package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.dto.PaymentDTO;
import br.com.compassuol.pb.challenge.ecommerce.entities.Payment;

public interface PaymentService {
    public Payment confirmPayment(Payment payment);
}
