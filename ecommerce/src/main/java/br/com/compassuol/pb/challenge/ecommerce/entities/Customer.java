package br.com.compassuol.pb.challenge.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @Column(name ="name")
    private String name;
    @Column(name ="CPF")
    private String CPF;
    @Column(name ="email")
    private String email;
    @Column(name ="active")
    private boolean active;

    public Customer(String name, String CPF, String email, boolean active) {
        this.name = name;
        this.CPF = CPF;
        this.email = email;
        this.active = active;
    }
}
