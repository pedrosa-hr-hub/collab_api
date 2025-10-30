package com.example.collab.exception.domain;

import com.example.collab.exception.business.ConflictException;

public class DuplicatedRGException extends ConflictException {

    public DuplicatedRGException(String message) {

        super(message);

    }

}
