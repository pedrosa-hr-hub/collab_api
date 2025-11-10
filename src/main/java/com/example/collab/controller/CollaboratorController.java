package com.example.collab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.collab.dto.request.CollaboratorRequestDTO;
import com.example.collab.dto.response.CollaboratorResponseDTO;
import com.example.collab.service.CollaboratorService;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/collaborators")
public class CollaboratorController {

    @Autowired
    private CollaboratorService collaboratorService;

    @PostMapping
    public ResponseEntity<CollaboratorResponseDTO> create(@RequestBody @Valid CollaboratorRequestDTO body) {
       
        CollaboratorResponseDTO response = collaboratorService.createCollaborator(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping
    public ResponseEntity<List<CollaboratorResponseDTO>> getAll() {

        List<CollaboratorResponseDTO> response = collaboratorService.getAllCollaborators();

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @GetMapping("/{regisrtration}")
    public ResponseEntity<CollaboratorResponseDTO> getByRegistration(@PathVariable Integer registration) {

        CollaboratorResponseDTO response = collaboratorService.getCollaboratorByRegistration(registration);

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @PutMapping("/{registration}")
    public ResponseEntity<CollaboratorResponseDTO> update(@PathVariable Integer registration, @RequestBody @Valid CollaboratorRequestDTO body) {
        
        CollaboratorResponseDTO response = collaboratorService.updateCollaborator(registration, body);

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }


}
