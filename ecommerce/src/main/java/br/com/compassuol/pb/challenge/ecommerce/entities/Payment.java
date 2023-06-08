package br.com.compassuol.pb.challenge.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "Payment")
public class Payment {
    public enum PaymentMethod {
        CREDIT_CARD,
        DEBIT_CARD,
        TRANSFER,
        PIX,
        CASH
    }

    @Id
    @Column(name = "paymentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @Column(nullable = false)
    @NotNull(message = "'paymentMethod' não pode ser nulo ou vazio")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(nullable = false)
    private LocalDate paymentDate;

    /*
    @Column(nullable = false)
    @NotEmpty(message = "'orderId' não pode ser nulo ou vazio")
    private Order orderId;
    */

    public Payment() {
    }

    public Payment(@NotNull PaymentMethod paymentMethod, LocalDate paymentDate) {
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public @NotNull PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(@NotNull PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", paymentMethod=" + paymentMethod +
                ", paymentDate=" + paymentDate +
                '}';
    }
}