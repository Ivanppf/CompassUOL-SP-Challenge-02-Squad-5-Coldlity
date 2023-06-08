package br.com.compassuol.sp.challenge.ecommerce.entities;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException{
    
    public CustomerNotFoundException(String message){
        super(message);
    }
}
