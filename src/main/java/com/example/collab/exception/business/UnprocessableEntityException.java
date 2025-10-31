package com.example.collab.exception.business;

import com.example.collab.exception.CollabApiException;

public class UnprocessableEntityException extends CollabApiException {

    public UnprocessableEntityException(String message) {

        super(message);
        
    }
}
