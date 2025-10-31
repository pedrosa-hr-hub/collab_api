package com.example.collab.exception.domain;

import com.example.collab.exception.business.ConflictException;

public class DuplicatedAccountException extends ConflictException {

    public DuplicatedAccountException(String message) {

        super(message);

    }

}
