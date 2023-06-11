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
    private PaymentServiceImpl paymentService;

    public PaymentRestController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payments")
    public Payment postPayment(@RequestBody Payment paymentProps) {
        return paymentService.confirmPayment(paymentProps);
    }
}
