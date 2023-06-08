package br.com.compassuol.pb.challenge.ecommerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(name ="name")
    private String name;

    @Column(name ="cpf")
    private String CPF;

    @Column(name ="email")
    private String email;

    @Column(name ="active")
    private boolean active;

    public Customer() {
    }

    public Customer(String name, String CPF, String email, boolean active) {
        this.name = name;
        this.CPF = CPF;
        this.email = email;
        this.active = active;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", CPF='" + CPF + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                '}';
    }
}
