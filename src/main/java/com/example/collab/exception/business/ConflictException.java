package com.example.collab.exception.business;

import com.example.collab.exception.CollabApiException;

public class ConflictException extends CollabApiException {

    public ConflictException(String message) {

        super(message);
        
    }
}
