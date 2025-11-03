package com.example.collab.mapper;

import org.springframework.stereotype.Component;

import com.example.collab.domain.model.Collaborator;
import com.example.collab.domain.valueobject.banking.*;
import com.example.collab.domain.valueobject.contact.Phone;
import com.example.collab.domain.valueobject.documento.*;
import com.example.collab.dto.request.CollaboratorRequestDTO;
import com.example.collab.dto.response.CollaboratorResponseDTO;

@Component
public class CollaboratorMapper {

    // Converte RequestDTO -> Entidade
    public Collaborator toEntity(CollaboratorRequestDTO dto) {
        var collaborator = new Collaborator();

        mapBasicFields(dto, collaborator);
        mapBankingFields(dto, collaborator);
        mapDocumentFields(dto, collaborator);
        mapEmergencyFields(dto, collaborator);

        return collaborator;
    }

    // Atualiza entidade existente com dados do DTO
    public void updateEntity(Collaborator collaborator, CollaboratorRequestDTO dto) {
        updateBasicFields(dto, collaborator);
        updateBankingFields(dto, collaborator);
        updateDocumentFields(dto, collaborator);
        updateEmergencyFields(dto, collaborator);
    }

    // Converte Entidade -> ResponseDTO
    public CollaboratorResponseDTO toResponse(Collaborator c) {
        return CollaboratorResponseDTO.builder()
                .tipoContrato(c.getTipoContrato())
                .salario(c.getSalario())
                .matricula(c.getMatricula())
                .cargaHoraria(c.getCargaHoraria())
                .certificadoReservista(c.getCertificadoReservista())
                .contatoEmergencia(c.getContatoEmergencia())
                .escolaridade(c.getEscolaridade())
                .curso(c.getCurso())
                // Banking
                .bank(extract(c.getBank(), Bank::getCode))
                .agency(extract(c.getAgency(), Agency::getNumber))
                .account(extract(c.getAccount(), Account::getNumber))
                .typeAccount(extract(c.getTypeAccount(), TypeAccount::getType))
                .pix(extract(c.getPix(), PIX::getKey))
                // Documents
                .carteiraTrabalho(extract(c.getCarteiraTrabalho(), CarteiraTrabalho::getNumero))
                .tituloEleitor(extract(c.getTituloEleitor(), TituloEleitor::getTitulo))
                .PIS(extract(c.getPIS(), PIS::getPis))
                .CNH(extract(c.getCNH(), CNH::getCnh))
                .CPF(extract(c.getCPF(), CPF::getCpf))
                .RG(extract(c.getRG(), RG::getRg))
                // Emergency
                .phoneEmergency(extract(c.getPhoneEmergency(), Phone::getNumber))
                .build();
    }

    // === MÉTODOS AUXILIARES PRIVADOS ===

    // Mapeia campos básicos (create)
    private void mapBasicFields(CollaboratorRequestDTO dto, Collaborator c) {
        c.setTipoContrato(dto.getTipoContrato());
        c.setSalario(dto.getSalario());
        c.setMatricula(dto.getMatricula());
        c.setCargaHoraria(dto.getCargaHoraria());
        c.setCertificadoReservista(dto.getCertificadoReservista());
        c.setContatoEmergencia(dto.getContatoEmergencia());
        c.setEscolaridade(dto.getEscolaridade());
        c.setCurso(dto.getCurso());
    }

    // Mapeia campos bancários (create)
    private void mapBankingFields(CollaboratorRequestDTO dto, Collaborator c) {
        if (notBlank(dto.getBank()))
            c.setBank(new Bank(dto.getBank()));
        if (notBlank(dto.getAgency()))
            c.setAgency(new Agency(dto.getAgency()));
        if (notBlank(dto.getAccount()))
            c.setAccount(new Account(dto.getAccount()));
        if (notBlank(dto.getTypeAccount()))
            c.setTypeAccount(new TypeAccount(dto.getTypeAccount()));
        if (notBlank(dto.getPix()))
            c.setPix(new PIX(dto.getPix()));
    }

    // Mapeia documentos (create)
    private void mapDocumentFields(CollaboratorRequestDTO dto, Collaborator c) {
        if (notBlank(dto.getCarteiraTrabalho()))
            c.setCarteiraTrabalho(new CarteiraTrabalho(dto.getCarteiraTrabalho()));
        if (notBlank(dto.getTituloEleitor()))
            c.setTituloEleitor(new TituloEleitor(dto.getTituloEleitor()));
        if (notBlank(dto.getPIS()))
            c.setPIS(new PIS(dto.getPIS()));
        if (notBlank(dto.getCNH()))
            c.setCNH(new CNH(dto.getCNH()));
        if (notBlank(dto.getCPF()))
            c.setCPF(new CPF(dto.getCPF()));
        if (notBlank(dto.getRG()))
            c.setRG(new RG(dto.getRG()));
    }

    // Mapeia emergência (create)
    private void mapEmergencyFields(CollaboratorRequestDTO dto, Collaborator c) {
        if (notBlank(dto.getPhoneEmergency()))
            c.setPhoneEmergency(new Phone(dto.getPhoneEmergency()));
    }

    // Atualiza campos básicos (update)
    private void updateBasicFields(CollaboratorRequestDTO dto, Collaborator c) {
        if (dto.getTipoContrato() != null)
            c.setTipoContrato(dto.getTipoContrato());
        if (dto.getSalario() != null)
            c.setSalario(dto.getSalario());
        if (dto.getMatricula() != null)
            c.setMatricula(dto.getMatricula());
        if (dto.getCargaHoraria() != null)
            c.setCargaHoraria(dto.getCargaHoraria());
        if (dto.getCertificadoReservista() != null)
            c.setCertificadoReservista(dto.getCertificadoReservista());
        if (dto.getContatoEmergencia() != null)
            c.setContatoEmergencia(dto.getContatoEmergencia());
        if (dto.getEscolaridade() != null)
            c.setEscolaridade(dto.getEscolaridade());
        if (dto.getCurso() != null)
            c.setCurso(dto.getCurso());
    }

    // Atualiza campos bancários (update)
    private void updateBankingFields(CollaboratorRequestDTO dto, Collaborator c) {
        if (dto.getBank() != null)
            c.setBank(createOrNull(dto.getBank(), Bank::new));
        if (dto.getAgency() != null)
            c.setAgency(createOrNull(dto.getAgency(), Agency::new));
        if (dto.getAccount() != null)
            c.setAccount(createOrNull(dto.getAccount(), Account::new));
        if (dto.getTypeAccount() != null)
            c.setTypeAccount(createOrNull(dto.getTypeAccount(), TypeAccount::new));
        if (dto.getPix() != null)
            c.setPix(createOrNull(dto.getPix(), PIX::new));
    }

    // Atualiza documentos (update)
    private void updateDocumentFields(CollaboratorRequestDTO dto, Collaborator c) {
        if (dto.getCarteiraTrabalho() != null)
            c.setCarteiraTrabalho(createOrNull(dto.getCarteiraTrabalho(), CarteiraTrabalho::new));
        if (dto.getTituloEleitor() != null)
            c.setTituloEleitor(createOrNull(dto.getTituloEleitor(), TituloEleitor::new));
        if (dto.getPIS() != null)
            c.setPIS(createOrNull(dto.getPIS(), PIS::new));
        if (dto.getCNH() != null)
            c.setCNH(createOrNull(dto.getCNH(), CNH::new));
        if (dto.getCPF() != null)
            c.setCPF(createOrNull(dto.getCPF(), CPF::new));
        if (dto.getRG() != null)
            c.setRG(createOrNull(dto.getRG(), RG::new));
    }

    // Atualiza emergência (update)
    private void updateEmergencyFields(CollaboratorRequestDTO dto, Collaborator c) {
        if (dto.getPhoneEmergency() != null)
            c.setPhoneEmergency(createOrNull(dto.getPhoneEmergency(), Phone::new));
    }

    // === HELPERS ===

    // Verifica se String não é nula nem em branco
    private static boolean notBlank(String s) {
        return s != null && !s.isBlank();
    }

    // Cria VO se não for branco, senão retorna null
    private static <T> T createOrNull(String value, java.util.function.Function<String, T> constructor) {
        return notBlank(value) ? constructor.apply(value) : null;
    }

    // Extrai valor do VO usando method reference
    private static <T, R> R extract(T vo, java.util.function.Function<T, R> getter) {
        return vo != null ? getter.apply(vo) : null;
    }
}