package com.example.collab.exception.domain;

import com.example.collab.exception.CollabApiException;

public class InvalidEmailException extends CollabApiException {
    public InvalidEmailException(String message) {
        super(message);
    }
}