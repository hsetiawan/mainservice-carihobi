package com.project.cari.hobi.mainservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, String id) {
        super(message + "id: " + id + "Not Found");
    }
}
