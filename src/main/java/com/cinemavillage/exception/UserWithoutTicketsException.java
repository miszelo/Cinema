package com.cinemavillage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "That user do not have any tickets")
public class UserWithoutTicketsException extends RuntimeException {
    public UserWithoutTicketsException() {
        super();
    }
}
