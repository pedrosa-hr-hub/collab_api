package com.example.collab.exception.domain;

import com.example.collab.exception.business.ConflictException;

public class DuplicatedCPFException extends ConflictException {

    public DuplicatedCPFException(String message) {

        super(message);

    }

}