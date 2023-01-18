package com.cinemavillage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "You cant change password to the same one!")
public class PasswordIsTheSameException extends RuntimeException {
    public PasswordIsTheSameException() {
        super();
    }
}
