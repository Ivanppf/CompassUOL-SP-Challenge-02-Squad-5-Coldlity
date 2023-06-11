package br.com.compassuol.pb.challenge.ecommerce.entities;

import br.com.compassuol.pb.challenge.ecommerce.enums.StatusOptions;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Entity
@Table(name = "Orders")
@JsonPropertyOrder({"orderId", "customer", "date", "status"})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @NotNull(message = "'customerId' não pode ser nulo")
    @Positive(message = "'customerId' deve ser um número positivo")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Customer customer;

    @Column(name = "orderDate", nullable = false)
    private LocalDate date;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusOptions status;

    public Order() {

    }

    public Order(Customer customer, LocalDate date, StatusOptions status) {
        this.customer = customer;
        this.date = date;
        this.status = status;
    }


    public int getOrderId() {
        return orderId;
    }

    @JsonProperty(value = "customerId")
    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public StatusOptions getStatus() {
        return status;
    }

    public void setStatus(StatusOptions status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customer +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}