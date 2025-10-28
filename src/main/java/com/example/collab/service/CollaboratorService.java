package com.example.collab.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.collab.domain.model.Collaborator;
import com.example.collab.domain.valueobject.bancario.Agencia;
import com.example.collab.domain.valueobject.bancario.Banco;
import com.example.collab.domain.valueobject.bancario.Conta;
import com.example.collab.domain.valueobject.bancario.TipoConta;
import com.example.collab.domain.valueobject.contato.Email;
import com.example.collab.domain.valueobject.contato.Telefone;
import com.example.collab.dto.request.CollaboratorRequestDTO;
import com.example.collab.dto.response.CollaboratorResponseDTO;
import com.example.collab.repository.CollaboratorRepository;
import com.example.collab.service.validation.CollaboratorValidator;

@Service
public class CollaboratorService {

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Autowired
    private CollaboratorValidator collaboratorValidator;

    @Autowired
    private ModelMapper modelMapper;

    public CollaboratorResponseDTO createCollaborator(CollaboratorRequestDTO req) {

        collaboratorValidator.validateNewCollaboratorDocuments(
                req.getCPF(),
                req.getRG(),
                req.getCNH(),
                req.getPIS(),
                req.getCarteiraTrabalho(),
                req.getTituloEleitor());

        collaboratorValidator.validateNewCollaboratorBank(
                req.getBanco(),
                req.getConta(),
                req.getPix());

        Collaborator collaborator = modelMapper.map(req, Collaborator.class);

        Collaborator savedCollaborator = collaboratorRepository.save(collaborator);

        return modelMapper.map(savedCollaborator, CollaboratorResponseDTO.class);
    }

    public List<CollaboratorResponseDTO> getAllCollaborators() {
        List<Collaborator> collaborators = collaboratorRepository.findAll();

        if (collaborators.isEmpty()) {
            throw new RuntimeException("Nenhum colaborador encontrado");
        }
        return collaborators.stream()
                .map(collaborator -> modelMapper.map(collaborator, CollaboratorResponseDTO.class))
                .toList();
    }

    public CollaboratorResponseDTO getCollaboratorByMatricula(Integer matricula) {

        Collaborator collaborator = collaboratorRepository.findByMatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Matricula não encontrada"));

        return modelMapper.map(collaborator, CollaboratorResponseDTO.class);
    }

    public CollaboratorResponseDTO getCollaboratorByCPF(String CPF) {

        Collaborator collaborator = collaboratorRepository.findByCPF(CPF)
                .orElseThrow(() -> new RuntimeException("CPF não encontrado"));

        return modelMapper.map(collaborator, CollaboratorResponseDTO.class);
    }

    public CollaboratorResponseDTO getCollaboratorByNome(String nome) {

        Collaborator collaborator = collaboratorRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Nome não encontrado"));

        return modelMapper.map(collaborator, CollaboratorResponseDTO.class);
    }

    public void deleteCollaboratorbyMatricula(Integer matricula) {

        Collaborator collaborator = collaboratorRepository.findByMatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado com a matrícula: " + matricula));

        collaboratorRepository.delete(collaborator);
    }

    public CollaboratorResponseDTO updateCollaborator(Integer matricula, CollaboratorRequestDTO req) {

        Collaborator existingCollaborator = collaboratorRepository.findByMatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado com a matrícula: " + matricula));

        existingCollaborator.setNome(req.getNome());
        existingCollaborator.setEstadoCivil(req.getEstadoCivil());
        existingCollaborator.setEmail(new Email(req.getEmail()));
        existingCollaborator.setTelefone(new Telefone(req.getTelefone()));
        existingCollaborator.setEndereco(req.getEndereco());
        existingCollaborator.setTipoConta(new TipoConta(req.getTipoConta()));
        existingCollaborator.setBanco(new Banco(req.getBanco()));
        existingCollaborator.setAgencia(new Agencia(req.getAgencia()));
        existingCollaborator.setConta(new Conta(req.getConta()));
        existingCollaborator.setContatoEmergencia(req.getContatoEmergencia());
        existingCollaborator.setTelefoneEmergencia(new Telefone(req.getTelefoneEmergencia()));
        existingCollaborator.setEscolaridade(req.getEscolaridade());
        existingCollaborator.setCurso(req.getCurso());
        existingCollaborator.setObservacoes(req.getObservacoes());

        Collaborator updatedCollaborator = collaboratorRepository.save(existingCollaborator);

        return modelMapper.map(updatedCollaborator, CollaboratorResponseDTO.class);
    }

}
