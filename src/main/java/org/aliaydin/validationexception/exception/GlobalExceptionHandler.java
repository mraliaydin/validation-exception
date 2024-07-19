package org.aliaydin.validationexception.exception;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public Map<String, String> handleInvalidArgument()

}
