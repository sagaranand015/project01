package com.ipsoft.demo.exceptions;

import lombok.Data;

@Data
public class ServiceException extends Exception {

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
