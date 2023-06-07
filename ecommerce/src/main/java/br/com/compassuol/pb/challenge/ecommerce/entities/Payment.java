package br.com.compassuol.pb.challenge.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "Payment")
public class Payment {
    private enum PaymentMethod {
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

    public Payment(PaymentMethod paymentMethod, LocalDate paymentDate) {
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
    }
}