package br.com.compassuol.pb.challenge.ecommerce.entities;

import br.com.compassuol.pb.challenge.ecommerce.enums.PaymentMethods;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "Payments")
@JsonPropertyOrder({"paymentId", "orderId", "paymentMethod", "paymentDate"})
public class Payment {
    @Id
    @Column(name = "paymentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @NotNull(message = "'orderId' can't be null or empty")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "fk_payment_order"))
    @JsonIdentityReference(alwaysAsId = true)
    private Order order;

    @Column(nullable = false)
    @NotNull(message = "'paymentMethod' can't be null or empty")
    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethod;

    @Column(nullable = false)
    private LocalDate paymentDate;

    public Payment() {
    }

    public Payment(Order order, @NotNull PaymentMethods paymentMethod, LocalDate paymentDate) {
        this.order = order;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    @JsonProperty(value = "orderId")
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

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", order=" + order +
                ", paymentMethod=" + paymentMethod +
                ", paymentDate=" + paymentDate +
                '}';
    }
}