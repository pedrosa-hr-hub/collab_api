package com.example.collab.exception.domain;

import com.example.collab.exception.resource.NotFoundException;

public class NotFoundCollaboratorException extends NotFoundException {

    public NotFoundCollaboratorException(String message) {

        super(message);

    }

}