package br.com.compassuol.pb.challenge.ecommerce.entities;

import br.com.compassuol.pb.challenge.ecommerce.enums.PaymentMethods;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @Column(name = "paymentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @Column(nullable = false)
    @NotNull(message = "'paymentMethod' não pode ser nulo ou vazio")
    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethod;

    @Column(nullable = false)
    private LocalDate paymentDate;

    /*
    @Column(nullable = false)
    @NotEmpty(message = "'orderId' não pode ser nulo ou vazio")
    private Order orderId;
    */

    public Payment() {
    }

    public Payment(@NotNull PaymentMethods paymentMethod, LocalDate paymentDate) {
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public @NotNull PaymentMethods getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(@NotNull PaymentMethods paymentMethod) {
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