package br.com.compassuol.pb.challenge.ecommerce.controllers;

import br.com.compassuol.pb.challenge.ecommerce.dto.PaymentDTO;
import br.com.compassuol.pb.challenge.ecommerce.repositories.PaymentRepository;
import br.com.compassuol.pb.challenge.ecommerce.services.PaymentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PaymentControllerTest {

    @InjectMocks
    private PaymentController paymentController;

    @Mock
    private PaymentServiceImpl paymentServiceImpl;

    @Mock
    private PaymentRepository paymentRepository;

    private PaymentDTO paymentProps;

    @Test
    void postPayment() {
        paymentProps = new PaymentDTO();
        var response = assertDoesNotThrow(() -> paymentController.postPayment(paymentProps));
        assertEquals(paymentServiceImpl.confirmPayment(paymentProps), response);
    }

}