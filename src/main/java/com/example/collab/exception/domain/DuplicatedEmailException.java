package com.example.collab.exception.domain;

import com.example.collab.exception.business.ConflictException;

public class DuplicatedEmailException extends ConflictException {

    public DuplicatedEmailException(String message) {

        super(message);

    }

}