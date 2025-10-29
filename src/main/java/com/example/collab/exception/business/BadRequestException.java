package com.example.collab.exception.business;

import com.example.collab.exception.CollabApiException;

public class BadRequestException extends CollabApiException {
    public BadRequestException(String message) {
        super(message);
    }
}
