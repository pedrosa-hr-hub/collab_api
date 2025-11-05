package com.example.collab.exception.domain;

import com.example.collab.exception.business.ConflictException;

public class DuplicatedWorkWalletException extends ConflictException {

    public DuplicatedWorkWalletException(String message) {

        super(message);

    }

}