package org.aliaydin.validationexception.exception;

import lombok.AllArgsConstructor;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(String message) {
        super(message);
    }
}
