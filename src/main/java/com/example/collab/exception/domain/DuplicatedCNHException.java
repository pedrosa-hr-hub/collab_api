package com.example.collab.exception.domain;

import com.example.collab.exception.business.ConflictException;

public class DuplicatedCNHException extends ConflictException {

    public DuplicatedCNHException(String message) {

        super(message);

    }

}
