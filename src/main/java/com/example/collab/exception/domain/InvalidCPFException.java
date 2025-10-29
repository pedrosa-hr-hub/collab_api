package com.example.collab.exception.domain;

public class InvalidCPFException extends InvalidDocumentException {
    public InvalidCPFException(String message) {
        super(message);
    }
}