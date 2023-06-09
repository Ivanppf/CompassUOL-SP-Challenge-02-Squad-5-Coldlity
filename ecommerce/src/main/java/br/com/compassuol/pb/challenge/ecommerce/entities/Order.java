package br.com.compassuol.pb.challenge.ecommerce.entities;

import br.com.compassuol.pb.challenge.ecommerce.enums.StatusOptions;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Integer orderId;

    @Column(name = "customerId", nullable = false)
    @NotNull(message = "'customerId' não pode ser nulo")
    @Positive(message = "'customerId' deve ser um número positivo")
    private Integer customerId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusOptions status;

    public Order() {

    }

    public Order(int customerId, LocalDate date, StatusOptions status) {
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
                ", customerId=" + customerId +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
