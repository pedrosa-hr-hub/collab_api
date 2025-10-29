package com.example.collab.exception.domain;

import com.example.collab.exception.CollabApiException;

public class InvalidTelefoneException extends CollabApiException {
    public InvalidTelefoneException(String message) {
        super(message);
    }
}