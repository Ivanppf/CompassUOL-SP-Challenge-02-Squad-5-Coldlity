package br.com.compassuol.pb.challenge.ecommerce.services;

import br.com.compassuol.pb.challenge.ecommerce.dto.PaymentDTO;
import br.com.compassuol.pb.challenge.ecommerce.entities.Order;
import br.com.compassuol.pb.challenge.ecommerce.entities.Payment;
import br.com.compassuol.pb.challenge.ecommerce.enums.StatusOptions;
import br.com.compassuol.pb.challenge.ecommerce.exceptions.OrderExceptions;
import br.com.compassuol.pb.challenge.ecommerce.repositories.OrderRepository;
import br.com.compassuol.pb.challenge.ecommerce.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;
    private OrderRepository orderRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Payment confirmPayment(PaymentDTO paymentProps) {
        Payment payment = getPayment(paymentProps);

        Optional<Order> orderOptional = orderRepository.findById(paymentProps.getOrder().getOrderId());

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();

            if (order.getStatus() == StatusOptions.CONFIRMED) {
                throw new OrderExceptions.OrderPaymentStatusConfirmedException("ORDER ID (" + order.getOrderId() + ") JÁ ESTÁ COM O STATUS 'CONFIRMED'");
            }

            order.setStatus(StatusOptions.CONFIRMED);

            return paymentRepository.save(payment);
        } else {
            throw new OrderExceptions.OrderNotFoundException("ORDER ID (" + paymentProps.getOrder().getOrderId() + ") NÃO ENCONTRADO");
        }
    }

    private static Payment getPayment(PaymentDTO paymentProps) {
        Order order = new Order();
        order.setOrderId(paymentProps.getOrder().getOrderId());

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setPaymentDate(paymentProps.getPaymentDate());
        payment.setPaymentMethod(paymentProps.getPaymentMethod());

        return payment;
    }
}
