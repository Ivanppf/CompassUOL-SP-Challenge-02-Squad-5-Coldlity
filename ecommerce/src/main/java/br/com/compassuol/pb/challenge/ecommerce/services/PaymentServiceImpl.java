package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.entities.Customer;
import br.com.compassuol.pb.challenge.ecommerce.entities.Order;
import br.com.compassuol.pb.challenge.ecommerce.entities.Payment;
import br.com.compassuol.pb.challenge.ecommerce.enums.PaymentMethods;
import br.com.compassuol.pb.challenge.ecommerce.enums.StatusOptions;
import br.com.compassuol.pb.challenge.ecommerce.exceptions.CustomerExceptions;
import br.com.compassuol.pb.challenge.ecommerce.exceptions.OrderExceptions;
import br.com.compassuol.pb.challenge.ecommerce.repositories.OrderRepository;
import br.com.compassuol.pb.challenge.ecommerce.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService{
    // Repositories
    private PaymentRepository paymentRepository;
    private OrderRepository orderRepository;

    // constructor - inject dependency's
    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    // post 1 payment - confirm payment
    @Override
    public Payment confirmPayment(Payment paymentProps) {
        Optional<Order> orderOptional = orderRepository.findById(paymentProps.getOrderId());

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setStatus(StatusOptions.CONFIRMED);

            return paymentRepository.save(new Payment(paymentProps.getOrderId(), paymentProps.getPaymentMethod(), paymentProps.getPaymentDate()));
        } else {
            throw new OrderExceptions.OrderNotFoundException("ORDER ID (" + paymentProps.getOrderId() + ") NÃO ENCONTRADO");
        }
    }
}
