package br.com.compassuol.pb.challenge.ecommerce.entities;

import br.com.compassuol.pb.challenge.ecommerce.enums.PaymentMethods;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
=======
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
>>>>>>> 5a6985e53dbddbfa1525ecf6d16186cf85ba5139
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "Payments")
<<<<<<< HEAD
@JsonPropertyOrder({"paymentId","orderId","paymentMethod","paymentDate"})
=======
@JsonPropertyOrder({"paymentId", "orderId", "paymentMethod", "paymentDate"})
>>>>>>> 5a6985e53dbddbfa1525ecf6d16186cf85ba5139
public class Payment {
    @Id
    @Column(name = "paymentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

<<<<<<< HEAD
    @Column(name = "orderId", nullable = false)
    @NotNull(message = "'orderId' can't be null or empty")
    @JsonIdentityReference(alwaysAsId = true)
    private Integer orderId;
=======
    @NotNull(message = "'orderId' can't be null or empty")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "fk_payment_order"))
    @JsonIdentityReference(alwaysAsId = true)
    private Order order;
>>>>>>> 5a6985e53dbddbfa1525ecf6d16186cf85ba5139

    @Column(nullable = false)
    @NotNull(message = "'paymentMethod' can't be null or empty")
    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethod;

    @Column(nullable = false)
    private LocalDate paymentDate;

    public Payment() {
    }

<<<<<<< HEAD
    public Payment(@NotNull int orderId, @NotNull PaymentMethods paymentMethod, LocalDate paymentDate) {
        this.orderId = orderId;
=======
    public Payment(Order order, @NotNull PaymentMethods paymentMethod, LocalDate paymentDate) {
        this.order = order;
>>>>>>> 5a6985e53dbddbfa1525ecf6d16186cf85ba5139
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

    public int getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
<<<<<<< HEAD
                ", orderId=" + orderId +
=======
                ", order=" + order +
>>>>>>> 5a6985e53dbddbfa1525ecf6d16186cf85ba5139
                ", paymentMethod=" + paymentMethod +
                ", paymentDate=" + paymentDate +
                '}';
    }
}