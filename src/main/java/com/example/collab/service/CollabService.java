package com.example.collab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.collab.repository.CollaboratorRepository;

@Service
public class CollabService {

    @Autowired
    private CollaboratorRepository collaboratorRepository;
}
