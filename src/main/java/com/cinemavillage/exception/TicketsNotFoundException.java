package com.cinemavillage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Tickets not found!")
public class TicketsNotFoundException extends RuntimeException {
    public TicketsNotFoundException() {
        super();
    }
}
