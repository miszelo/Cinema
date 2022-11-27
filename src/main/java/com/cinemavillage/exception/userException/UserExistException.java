package com.cinemavillage.exception.userException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "User already exist!")
public class UserExistException extends RuntimeException {

    public UserExistException() {
        super();
    }
}
