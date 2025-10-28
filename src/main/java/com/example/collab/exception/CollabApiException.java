package com.example.collab.exception;

public class CollabApiException extends RuntimeException {
    public CollabApiException(String message) {
        super(message);
    }

    public CollabApiException(String message, Throwable cause) {
        super(message, cause);
    }

}
