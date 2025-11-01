package com.example.collab.exception.domain;

import com.example.collab.exception.CollabApiException;

public class InvalidDocumentException extends CollabApiException {

    public InvalidDocumentException(String message) {

        super(message);

    }
}