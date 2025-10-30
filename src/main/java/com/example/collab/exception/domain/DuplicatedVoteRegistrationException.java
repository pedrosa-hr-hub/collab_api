package com.example.collab.exception.domain;

import com.example.collab.exception.business.ConflictException;

public class DuplicatedVoteRegistrationException extends ConflictException {

    public DuplicatedVoteRegistrationException(String message) {

        super(message);

    }

}
