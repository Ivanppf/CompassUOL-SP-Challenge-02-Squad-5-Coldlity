package br.com.compassuol.pb.challenge.ecommerce.entities;

import br.com.compassuol.pb.challenge.ecommerce.enums.StatusOption;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private int orderId;

    @Column(name = "customerId", nullable = false)
    @NotNull(message = "'customerId' não pode ser nulo")
    @Positive(message = "'customerId' deve ser um número positivo")
    private int customerId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "status", nullable = false)
    private StatusOption status;

    public Order() {

    }

    public Order(int customerId, LocalDate date, StatusOption status) {
        this.customerId = customerId;
        this.date = date;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getOrderDate() {
        return date;
    }

    public void setOrderDate(LocalDate date) {
        this.date = date;
    }

    public StatusOption getStatus() {
        return status;
    }

    public void setStatus(StatusOption status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", orderDate=" + date +
                ", status=" + status +
                '}';
    }
}
