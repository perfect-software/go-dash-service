package com.service.godash.Exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class GenericException extends RuntimeException{

    private Integer errorCode;

    public GenericException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public GenericException(String message) {
        this(message, HttpStatus.BAD_REQUEST.value());
    }

}
