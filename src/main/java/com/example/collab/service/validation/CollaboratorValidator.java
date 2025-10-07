package com.example.collab.service.validation;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.collab.repository.CollaboratorRepository;

@Component
public class CollaboratorValidator {

    private CollaboratorRepository collaboratorRepository;

    public void validateNewCollaboratorDocuments(String cpf, String RG, String CNH, String PIS, String carteiraTrabalho,
            String tituloEleitor) {

        if (collaboratorRepository.findByCPF(cpf).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF já cadastrado");
        }

        if (collaboratorRepository.findByRG(RG).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "RG já cadastrado");
        }

        if (collaboratorRepository.findByCNH(CNH).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CNH já cadastrada");
        }

    }

}
