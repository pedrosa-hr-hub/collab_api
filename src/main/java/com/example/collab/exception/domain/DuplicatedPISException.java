package com.example.collab.exception.domain;

import com.example.collab.exception.business.ConflictException;

public class DuplicatedPISException extends ConflictException {

    public DuplicatedPISException(String message) {

        super(message);

    }

}
