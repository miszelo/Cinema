package com.cinemavillage.exception.userException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception thrown if user already exist in database
 * @author Michal Kawczak, Jakub Mikos
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "User already exist!")
public class UserExistException extends RuntimeException {

    public UserExistException() {
        super();
    }
}
