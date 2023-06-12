package br.com.compassuol.pb.challenge.ecommerce.dto;

import br.com.compassuol.pb.challenge.ecommerce.enums.StatusOptions;

import java.time.LocalDate;

public class OrderDTO {

    private CustomerDTO customer;

    private LocalDate date;

    private StatusOptions status;

    public OrderDTO(CustomerDTO customer, LocalDate date, StatusOptions status) {
        this.customer = customer;
        this.date = date;
        this.status = status;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public StatusOptions getStatus() {
        return status;
    }

}