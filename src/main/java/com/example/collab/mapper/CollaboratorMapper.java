package com.example.collab.mapper; // Define o pacote onde o mapper reside

import org.springframework.stereotype.Component; // Permite registrar esta classe como bean Spring

// Imports da entidade e dos Value Objects usados na montagem/conversão
import com.example.collab.domain.model.Collaborator;
import com.example.collab.domain.valueobject.banking.Agency;
import com.example.collab.domain.valueobject.banking.Bank;
import com.example.collab.domain.valueobject.banking.Account;
import com.example.collab.domain.valueobject.banking.PIX;
import com.example.collab.domain.valueobject.banking.TypeAccount;
import com.example.collab.domain.valueobject.contact.Phone;
import com.example.collab.domain.valueobject.documento.CNH;
import com.example.collab.domain.valueobject.documento.CPF;
import com.example.collab.domain.valueobject.documento.CarteiraTrabalho;
import com.example.collab.domain.valueobject.documento.PIS;
import com.example.collab.domain.valueobject.documento.RG;
import com.example.collab.domain.valueobject.documento.TituloEleitor;
import com.example.collab.dto.request.CollaboratorRequestDTO;
import com.example.collab.dto.response.CollaboratorResponseDTO;

@Component // Marca o mapper como componente Spring para injeção (DI)
public class CollaboratorMapper {

    // Converte o DTO de request em entidade, instanciando VOs quando houver valor
    public Collaborator toEntity(CollaboratorRequestDTO dto) {
        var c = new Collaborator(); // Cria uma nova entidade vazia

        // Copia campos simples (Strings/números) diretamente do DTO para a entidade
        c.setTipoContrato(dto.getTipoContrato()); // tipo de contrato
        c.setSalario(dto.getSalario()); // salário
        c.setMatricula(dto.getMatricula()); // matrícula
        c.setCargaHoraria(dto.getCargaHoraria()); // carga horária
        c.setCertificadoReservista(dto.getCertificadoReservista()); // certificado reservista
        c.setContatoEmergencia(dto.getContatoEmergencia()); // contato de emergência
        c.setEscolaridade(dto.getEscolaridade()); // escolaridade
        c.setCurso(dto.getCurso()); // curso

        // Monta os VOs bancários somente se houver String não vazia no DTO
        if (nb(dto.getBank()))
            c.setBank(new Bank(dto.getBank())); // Bank(código)
        if (nb(dto.getAgency()))
            c.setAgency(new Agency(dto.getAgency())); // Agency(número)
        if (nb(dto.getAccount()))
            c.setAccount(new Account(dto.getAccount())); // Account(número)
        if (nb(dto.getTypeAccount()))
            c.setTypeAccount(new TypeAccount(dto.getTypeAccount())); // TypeAccount(tipo)
        if (nb(dto.getPix()))
            c.setPix(new PIX(dto.getPix())); // PIX(chave)

        // Monta os VOs de documentos se informados
        if (nb(dto.getCarteiraTrabalho()))
            c.setCarteiraTrabalho(new CarteiraTrabalho(dto.getCarteiraTrabalho())); // CTPS
        if (nb(dto.getTituloEleitor()))
            c.setTituloEleitor(new TituloEleitor(dto.getTituloEleitor())); // Título
        if (nb(dto.getPIS()))
            c.setPIS(new PIS(dto.getPIS())); // PIS
        if (nb(dto.getCNH()))
            c.setCNH(new CNH(dto.getCNH())); // CNH
        if (nb(dto.getCPF()))
            c.setCPF(new CPF(dto.getCPF())); // CPF
        if (nb(dto.getRG()))
            c.setRG(new RG(dto.getRG())); // RG

        // Monta VO de telefone de emergência, se informado
        if (nb(dto.getPhoneEmergency()))
            c.setPhoneEmergency(new Phone(dto.getPhoneEmergency()));

        return c; // Retorna a entidade pronta para persistência
    }

    // Atualiza parcialmente a entidade com dados do DTO (só aplica o que não for
    // null)
    public void updateEntity(Collaborator c, CollaboratorRequestDTO dto) {
        // Atualiza campos simples quando presentes
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

        // Se o campo veio null, não altera; se veio vazio, zera (seta null); se veio
        // valor, recria o VO
        if (dto.getBank() != null)
            c.setBank(nb(dto.getBank()) ? new Bank(dto.getBank()) : null);
        if (dto.getAgency() != null)
            c.setAgency(nb(dto.getAgency()) ? new Agency(dto.getAgency()) : null);
        if (dto.getAccount() != null)
            c.setAccount(nb(dto.getAccount()) ? new Account(dto.getAccount()) : null);
        if (dto.getTypeAccount() != null)
            c.setTypeAccount(nb(dto.getTypeAccount()) ? new TypeAccount(dto.getTypeAccount()) : null);
        if (dto.getPix() != null)
            c.setPix(nb(dto.getPix()) ? new PIX(dto.getPix()) : null);

        if (dto.getCarteiraTrabalho() != null)
            c.setCarteiraTrabalho(
                    nb(dto.getCarteiraTrabalho()) ? new CarteiraTrabalho(dto.getCarteiraTrabalho()) : null);
        if (dto.getTituloEleitor() != null)
            c.setTituloEleitor(nb(dto.getTituloEleitor()) ? new TituloEleitor(dto.getTituloEleitor()) : null);
        if (dto.getPIS() != null)
            c.setPIS(nb(dto.getPIS()) ? new PIS(dto.getPIS()) : null);
        if (dto.getCNH() != null)
            c.setCNH(nb(dto.getCNH()) ? new CNH(dto.getCNH()) : null);
        if (dto.getCPF() != null)
            c.setCPF(nb(dto.getCPF()) ? new CPF(dto.getCPF()) : null);
        if (dto.getRG() != null)
            c.setRG(nb(dto.getRG()) ? new RG(dto.getRG()) : null);

        if (dto.getPhoneEmergency() != null)
            c.setPhoneEmergency(nb(dto.getPhoneEmergency()) ? new Phone(dto.getPhoneEmergency()) : null);
    }

    // Converte a entidade em DTO de resposta, extraindo os valores dos VOs
    public CollaboratorResponseDTO toResponse(Collaborator c) {
        return CollaboratorResponseDTO.builder() // Usa builder do DTO de resposta
                .tipoContrato(c.getTipoContrato()) // Copia tipo de contrato
                .salario(c.getSalario()) // Copia salário
                .matricula(c.getMatricula()) // Copia matrícula
                .cargaHoraria(c.getCargaHoraria()) // Copia carga horária
                // Extrai valores primitivos dos VOs bancários
                .bank(c.getBank() != null ? c.getBank().getCode() : null)
                .agency(c.getAgency() != null ? c.getAgency().getNumber() : null)
                .account(c.getAccount() != null ? c.getAccount().getNumber() : null)
                .typeAccount(c.getTypeAccount() != null ? c.getTypeAccount().getType() : null)
                .pix(c.getPix() != null ? c.getPix().getKey() : null)
                // Extrai valores dos documentos
                .carteiraTrabalho(c.getCarteiraTrabalho() != null ? c.getCarteiraTrabalho().getNumero() : null)
                .tituloEleitor(c.getTituloEleitor() != null ? c.getTituloEleitor().getTitulo() : null)
                .certificadoReservista(c.getCertificadoReservista())
                .PIS(c.getPIS() != null ? c.getPIS().getPis() : null)
                .CNH(c.getCNH() != null ? c.getCNH().getCnh() : null)
                .CPF(c.getCPF() != null ? c.getCPF().getCpf() : null)
                .RG(c.getRG() != null ? c.getRG().getRg() : null)
                // Campos de emergência e adicionais
                .contatoEmergencia(c.getContatoEmergencia())
                .phoneEmergency(c.getPhoneEmergency() != null ? c.getPhoneEmergency().getNumber() : null)
                .escolaridade(c.getEscolaridade())
                .curso(c.getCurso())
                .build(); // Finaliza a construção do DTO
    }

    // Helper: verifica se uma String não é nula nem em branco
    private static boolean nb(String s) {
        return s != null && !s.isBlank();
    }
}