package com.todolistapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_MODIFIED)
public class ResourceNotModifiedException extends Exception{

    /**
     * Instantiates a new Resource not found exception.
     *
     * @param message the message
     */
    public ResourceNotModifiedException(String message) {
        super(message);
    }

}
