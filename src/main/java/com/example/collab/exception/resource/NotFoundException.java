package com.example.collab.exception.resource;

import com.example.collab.exception.CollabApiException;

public class NotFoundException extends CollabApiException {

    public NotFoundException(String message) {

        super(message);
        
    }
}
