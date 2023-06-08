package br.com.compassuol.pb.challenge.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ProductExceptions {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class ProductNameException extends RuntimeException {
        public ProductNameException(String message) {
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class ProductDescriptionException extends RuntimeException {
        public ProductDescriptionException(String message) {
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class ProductPriceException extends RuntimeException {
        public ProductPriceException (String message) {
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class ProductNotFoundException extends RuntimeException {
        public ProductNotFoundException (String message) {
            super(message);
        }
    }
}
