package br.com.compassuol.pb.challenge.ecommerce.entities;

import br.com.compassuol.pb.challenge.ecommerce.enums.PaymentMethods;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "Payments")
@JsonPropertyOrder({"paymentId","orderId","paymentMethod","paymentDate"})
public class Payment {
    @Id
    @Column(name = "paymentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @Column(name = "orderId", nullable = false)
    @NotNull(message = "'orderId' não pode ser nulo ou vazio")
    @JsonIdentityReference(alwaysAsId = true)
    private Integer orderId;

    @Column(nullable = false)
    @NotNull(message = "'paymentMethod' não pode ser nulo ou vazio")
    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethod;

    @Column(nullable = false)
    private LocalDate paymentDate;

    public Payment() {
    }

    public Payment(@NotNull int orderId, @NotNull PaymentMethods paymentMethod, LocalDate paymentDate) {
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
    }

    public Integer getPaymentId() {
        return paymentId;
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

    public int getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", orderId=" + orderId +
                ", paymentMethod=" + paymentMethod +
                ", paymentDate=" + paymentDate +
                '}';
    }
}