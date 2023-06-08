package br.com.compassuol.pb.challenge.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class OrderExceptions {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class OrderNotFoundException extends RuntimeException {
        public OrderNotFoundException (String message) {
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class OrderPaymentStatusConfirmedException extends RuntimeException {
        public OrderPaymentStatusConfirmedException (String message) {
            super(message);
        }
    }
}
