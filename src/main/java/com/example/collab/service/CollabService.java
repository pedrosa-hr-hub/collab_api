package com.example.collab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.collab.dto.CollaboratorDTO;
import com.example.collab.model.Collaborator;
import com.example.collab.repository.CollaboratorRepository;
import com.example.collab.service.validation.CollaboratorValidator;

@Service
public class CollabService {

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Autowired
    private CollaboratorValidator collaboratorValidator;

    public CollaboratorDTO createCollaborator(CollaboratorDTO collaboratorDTO) {

        collaboratorValidator.validateNewCollaboratorDocuments(
                collaboratorDTO.CPF(),
                collaboratorDTO.RG(),
                collaboratorDTO.CNH(),
                collaboratorDTO.PIS(),
                collaboratorDTO.CarteiraTrabalho(),
                collaboratorDTO.TituloEleitor());

        collaboratorValidator.validateNewCollaboratorBank(
                collaboratorDTO.Banco(),
                collaboratorDTO.Conta(),
                collaboratorDTO.Pix());

        Collaborator collaborator = new Collaborator();

        Collaborator savedCollaborator = collaboratorRepository.save(collaborator);

        return new CollaboratorDTO();
    }

    public List<CollaboratorDTO> getAllCollaborators() {
        List<Collaborator> collaborators = collaboratorRepository.findAll();

        if (collaborators.isEmpty()) {
            throw new RuntimeException("Nenhum colaborador encontrado");
        }

        return collaborators.stream()
                .map(collaborator -> new CollaboratorDTO())
                .toList();
    }

    public CollaboratorDTO getCollaboratorByMatricula(Integer matricula) {

        Collaborator collaborator = collaboratorRepository.findByMatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Matricula não encontrada"));

        return new CollaboratorDTO();
    }

    public CollaboratorDTO getCollaboratorByCPF(String CPF) {

        Collaborator collaborator = collaboratorRepository.findByCPF(CPF)
                .orElseThrow(() -> new RuntimeException("CPF não encontrado"));

        return new CollaboratorDTO();
    }

    public CollaboratorDTO getCollaboratorByNome(String nome) {

        Collaborator collaborator = collaboratorRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Nome não encontrado"));

        return new CollaboratorDTO();
    }

}
