package br.com.compassuol.pb.challenge.ecommerce.services;

<<<<<<< HEAD
=======
import br.com.compassuol.pb.challenge.ecommerce.dto.PaymentDTO;
>>>>>>> 5a6985e53dbddbfa1525ecf6d16186cf85ba5139
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
<<<<<<< HEAD
public class PaymentServiceImpl implements PaymentService{
    // Repositories
    private PaymentRepository paymentRepository;
    private OrderRepository orderRepository;

    // constructor - inject dependency's
=======
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository paymentRepository;
    private OrderRepository orderRepository;

>>>>>>> 5a6985e53dbddbfa1525ecf6d16186cf85ba5139
    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    // post 1 payment - confirm payment
    @Override
<<<<<<< HEAD
    public Payment confirmPayment(Payment paymentProps) {
        Optional<Order> orderOptional = orderRepository.findById(paymentProps.getOrderId());

=======
    public Payment confirmPayment(PaymentDTO paymentProps) {
        Payment payment = getPayment(paymentProps);

        Optional<Order> orderOptional = orderRepository.findById(paymentProps.getOrder().getOrderId());

>>>>>>> 5a6985e53dbddbfa1525ecf6d16186cf85ba5139
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();

            if (order.getStatus() == StatusOptions.CONFIRMED) {
<<<<<<< HEAD
                throw new OrderExceptions.OrderPaymentStatusConfirmedException("ORDER ID (" + order.getOrderId()  + ") JÁ ESTÁ COM O STATUS 'CONFIRMED'");
=======
                throw new OrderExceptions.OrderPaymentStatusConfirmedException("ORDER ID (" + order.getOrderId() + ") JÁ ESTÁ COM O STATUS 'CONFIRMED'");
>>>>>>> 5a6985e53dbddbfa1525ecf6d16186cf85ba5139
            }

            order.setStatus(StatusOptions.CONFIRMED);

<<<<<<< HEAD
            return paymentRepository.save(new Payment(paymentProps.getOrderId(), paymentProps.getPaymentMethod(), paymentProps.getPaymentDate()));
        } else {
            throw new OrderExceptions.OrderNotFoundException("ORDER ID (" + paymentProps.getOrderId() + ") NÃO ENCONTRADO");
        }
=======
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
>>>>>>> 5a6985e53dbddbfa1525ecf6d16186cf85ba5139
    }
}
