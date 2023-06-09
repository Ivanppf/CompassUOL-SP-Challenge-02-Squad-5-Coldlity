package br.com.compassuol.pb.challenge.ecommerce.controllers;

import br.com.compassuol.pb.challenge.ecommerce.entities.Payment;
import br.com.compassuol.pb.challenge.ecommerce.services.PaymentServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class PaymentRestController {
    // Service
    private PaymentServiceImpl paymentService;

    // constructor - inject service dependency
    public PaymentRestController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    // post 1 payment
    @PostMapping("/payments")
    public Payment postPayment(@RequestBody Payment paymentProps) {
        return paymentService.confirmPayment(paymentProps);
    }
}
