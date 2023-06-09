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
    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
//    @Column(name = "customer_id", nullable = false)
    @NotNull(message = "'customerId' não pode ser nulo")
    @Positive(message = "'customerId' deve ser um número positivo")
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

    public int getCustomer() {
        return customer.getCustomerId();
    }
//    public Customer getCustomer() {
//        return customer;
//    }

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