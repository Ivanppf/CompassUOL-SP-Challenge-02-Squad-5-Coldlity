package br.com.compassuol.pb.challenge.ecommerce.dto;

import br.com.compassuol.pb.challenge.ecommerce.entities.Order;
import br.com.compassuol.pb.challenge.ecommerce.enums.PaymentMethods;

import java.time.LocalDate;

public class PaymentDTO {
    private Order order;

    private PaymentMethods paymentMethod;

    private LocalDate paymentDate;

    public PaymentDTO() {
    }

    public PaymentDTO(Order order, PaymentMethods paymentMethod, LocalDate paymentDate) {
        this.order = order;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public PaymentMethods getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethods paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}