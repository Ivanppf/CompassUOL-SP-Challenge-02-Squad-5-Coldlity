package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.entities.Payment;
import br.com.compassuol.pb.challenge.ecommerce.enums.PaymentMethods;
import br.com.compassuol.pb.challenge.ecommerce.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PaymentServiceImpl implements PaymentService{
    private PaymentRepository paymentRepository;
    // private OrderRepository orderRepository;

    /*
    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }
    */

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


    @Override
    public Payment confirmPayment(Payment paymentProps) {
        PaymentMethods paymentMethod = paymentProps.getPaymentMethod();
        LocalDate paymentDate = paymentProps.getPaymentDate();

        return paymentRepository.save(new Payment(paymentMethod, paymentDate));
    }
}
