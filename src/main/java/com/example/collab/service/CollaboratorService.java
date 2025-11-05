package com.example.collab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.collab.domain.model.Collaborator;
import com.example.collab.domain.valueobject.banking.Agency;
import com.example.collab.domain.valueobject.banking.Bank;
import com.example.collab.domain.valueobject.banking.Account;
import com.example.collab.domain.valueobject.banking.TypeAccount;
import com.example.collab.domain.valueobject.contact.Email;
import com.example.collab.domain.valueobject.contact.Phone;
import com.example.collab.dto.request.CollaboratorRequestDTO;
import com.example.collab.dto.response.CollaboratorResponseDTO;
import com.example.collab.exception.domain.InvalidCollaboratorException;
import com.example.collab.mapper.CollaboratorMapper;
import com.example.collab.repository.CollaboratorRepository;
import com.example.collab.service.validation.CollaboratorValidator;

@Service
public class CollaboratorService {

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Autowired
    private CollaboratorValidator collaboratorValidator;

    @Autowired
    private CollaboratorMapper collaboratorMapper;

    public CollaboratorResponseDTO createCollaborator(CollaboratorRequestDTO req) {

        collaboratorValidator.validateNewCollaboratorDocuments(
                req.getCPF(),
                req.getRG(),
                req.getCNH(),
                req.getPIS(),
                req.getCarteiraTrabalho(),
                req.getVoterRegistration());

        collaboratorValidator.validateNewCollaboratorBank(
                req.getAccount(),
                req.getPix());

        Collaborator collaborator = collaboratorMapper.toEntity(req);

        if (collaborator != null) {

            Collaborator savedCollaborator = collaboratorRepository.save(collaborator);

            return collaboratorMapper.toResponse(savedCollaborator);

        }

        throw new InvalidCollaboratorException("Error creating collaborator");

    }

    public List<CollaboratorResponseDTO> getAllCollaborators() {
        List<Collaborator> collaborators = collaboratorRepository.findAll();

        if (collaborators.isEmpty()) {
            throw new RuntimeException("Nenhum colaborador encontrado");
        }
        return collaborators.stream()
                .map(collaborator -> collaboratorMapper.toResponse(collaborator))
                .toList();
    }

    public CollaboratorResponseDTO getCollaboratorByMatricula(Integer matricula) {

        Collaborator collaborator = collaboratorRepository.findByMatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Matricula não encontrada"));

        return collaboratorMapper.toResponse(collaborator);

    }

    public CollaboratorResponseDTO getCollaboratorByCPF(String CPF) {

        Collaborator collaborator = collaboratorRepository.findByCPF(CPF)
                .orElseThrow(() -> new RuntimeException("CPF não encontrado"));

        return collaboratorMapper.toResponse(collaborator);

    }

    public CollaboratorResponseDTO getCollaboratorByName(String name) {

        Collaborator collaborator = collaboratorRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Nome não encontrado"));

        return collaboratorMapper.toResponse(collaborator);

    }

    public void deleteCollaboratorbyMatricula(Integer matricula) {

        Collaborator collaborator = collaboratorRepository.findByMatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado com a matrícula: " + matricula));

        if (collaborator != null) {

            collaboratorRepository.delete(collaborator);

        }

        throw new RuntimeException("Colaborador não encontrado com a matrícula: " + matricula);

    }

    public CollaboratorResponseDTO updateCollaborator(Integer matricula, CollaboratorRequestDTO req) {

        Collaborator existingCollaborator = collaboratorRepository.findByMatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado com a matrícula: " + matricula));

        existingCollaborator.setName(req.getName());

        existingCollaborator.setMaritalStatus(req.getMaritalStatus());

        existingCollaborator.setEmail(new Email(req.getEmail()));

        existingCollaborator.setPhone(new Phone(req.getPhone()));

        existingCollaborator.setEndereco(req.getEndereco());

        existingCollaborator.setTypeAccount(new TypeAccount(req.getTypeAccount()));

        existingCollaborator.setBank(new Bank(req.getBank()));

        existingCollaborator.setAgency(new Agency(req.getAgency()));

        existingCollaborator.setAccount(new Account(req.getAccount()));

        existingCollaborator.setContatoEmergencia(req.getContatoEmergencia());

        existingCollaborator.setPhoneEmergency(new Phone(req.getPhoneEmergency()));

        existingCollaborator.setEscolaridade(req.getEscolaridade());

        existingCollaborator.setCurso(req.getCurso());

        existingCollaborator.setObservacoes(req.getObservacoes());

        Collaborator updatedCollaborator = collaboratorRepository.save(existingCollaborator);

        return collaboratorMapper.toResponse(updatedCollaborator);
    }

}
