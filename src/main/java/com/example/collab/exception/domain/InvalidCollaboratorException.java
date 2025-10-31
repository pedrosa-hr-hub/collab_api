package com.example.collab.exception.domain;

import com.example.collab.exception.business.UnprocessableEntityException;

public class InvalidCollaboratorException extends UnprocessableEntityException {

    public InvalidCollaboratorException(String message) {

        super(message);

    }

}
