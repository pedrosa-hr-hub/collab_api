package com.example.collab.exception.domain;

import com.example.collab.exception.business.ConflictException;

public class DuplicatedPixException extends ConflictException {

    public DuplicatedPixException(String message) {

        super(message);

    }

}
