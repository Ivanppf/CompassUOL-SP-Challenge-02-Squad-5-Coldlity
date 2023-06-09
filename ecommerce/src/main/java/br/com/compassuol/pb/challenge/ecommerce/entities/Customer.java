package br.com.compassuol.pb.challenge.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Customers")
public class Customer {
    @Id
    @Column(name = "customerId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Size(min = 3, message = "'name' deve ter no mínimo 3 caracteres")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "não pode ser nulo ou vazio")
    @Column(name = "cpf", unique = true)
    private String cpf;

    @NotEmpty(message = "não pode ser nulo ou vazio")
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "active")
    private boolean active;

    public Customer(){

    }

    public Customer(String name, String cpf, String email, boolean active) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.active = active;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                '}';
    }

}
