package br.com.compassuol.pb.challenge.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomerExceptions {
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public static class CustomerNotFoundException extends RuntimeException {
        public CustomerNotFoundException(String message){
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class CustomerNameException extends RuntimeException {
        public CustomerNameException(String message) {
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class CustomerCpfException extends RuntimeException {
        public CustomerCpfException(String message) {
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class CustomerEmailException extends RuntimeException {
        public CustomerEmailException (String message) {
            super(message);
        }
    }
}
