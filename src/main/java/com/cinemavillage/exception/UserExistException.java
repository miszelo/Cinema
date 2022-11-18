package com.cinemavillage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User already exist!")
public class UserExistException extends RuntimeException {

    public UserExistException() {
        super();
    }
}
