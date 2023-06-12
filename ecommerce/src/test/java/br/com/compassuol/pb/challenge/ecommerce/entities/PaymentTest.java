package br.com.compassuol.pb.challenge.ecommerce.entities;

import br.com.compassuol.pb.challenge.ecommerce.enums.PaymentMethods;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    void getPaymentId() {
        Payment payment =  new Payment();
        Integer paymentId = payment.getPaymentId();
        assertNull(paymentId);
    }

    @Test
    void setPaymentId() {
        Payment payment =  new Payment();
        Integer activeId = 1;
        payment.setPaymentId(activeId);
        assertEquals( 1, payment.getPaymentId());
    }

    @Test
    void getPaymentMethod() {
        Payment payment =  new Payment();
        @NotNull PaymentMethods paymentMethod = payment.getPaymentMethod();
        assertNull(paymentMethod);
    }

    @Test
    void setPaymentMethod() {
        Payment payment =  new Payment();
        Payment paymentMethod = payment;
        payment.setPaymentMethod(PaymentMethods.CASH);
        payment.setPaymentMethod(PaymentMethods.PIX);
        payment.setPaymentMethod(PaymentMethods.CREDIT_CARD);
        payment.setPaymentMethod(PaymentMethods.DEBIT_CARD);
        payment.setPaymentMethod(PaymentMethods.TRANSFER);
        assertEquals( payment, paymentMethod);
    }

    @Test
    void getPaymentDate() {
        Payment payment =  new Payment();
        LocalDate paymentMethodDate = payment.getPaymentDate();
        assertNull(paymentMethodDate);
    }

    @Test
    void setPaymentDate() {
        Payment payment =  new Payment();
        Payment paymentMethodDatee = payment;
        payment.setPaymentDate(paymentMethodDatee.getPaymentDate());
        assertEquals( payment, paymentMethodDatee);
    }

    @Test
    void testToString() {
        Payment payment =  new Payment();
        String paymentString = payment.toString();
        assertEquals("Payment{" +
                "paymentId=" + null +
                ", paymentMethod=" + null +
                ", paymentDate=" + null +
                '}', paymentString);
    }

}