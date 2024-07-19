package org.aliaydin.validationexception.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

    private LocalDateTime localDateTime;
    private String message;
    private String errorCode;
    private Map<String, String> fieldErrors;
}



