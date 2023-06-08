package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.entities.Payment;
import br.com.compassuol.pb.challenge.ecommerce.enums.PaymentMethods;
import br.com.compassuol.pb.challenge.ecommerce.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

public interface PaymentService {
    public Payment confirmPayment(Payment paymentProps);
}
