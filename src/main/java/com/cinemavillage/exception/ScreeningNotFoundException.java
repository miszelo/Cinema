package com.cinemavillage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Screening not found!")
public class ScreeningNotFoundException extends RuntimeException {
    public ScreeningNotFoundException() {
        super();
    }
}
