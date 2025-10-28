package com.example.collab.mapper; // Define o pacote onde o mapper reside

import org.springframework.stereotype.Component; // Permite registrar esta classe como bean Spring

// Imports da entidade e dos Value Objects usados na montagem/conversão
import com.example.collab.domain.model.Collaborator;
import com.example.collab.domain.valueobject.bancario.Agencia;
import com.example.collab.domain.valueobject.bancario.Banco;
import com.example.collab.domain.valueobject.bancario.Conta;
import com.example.collab.domain.valueobject.bancario.PIX;
import com.example.collab.domain.valueobject.bancario.TipoConta;
import com.example.collab.domain.valueobject.contato.Telefone;
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
        if (nb(dto.getBanco()))
            c.setBanco(new Banco(dto.getBanco())); // Banco(código)
        if (nb(dto.getAgencia()))
            c.setAgencia(new Agencia(dto.getAgencia())); // Agencia(número)
        if (nb(dto.getConta()))
            c.setConta(new Conta(dto.getConta())); // Conta(número)
        if (nb(dto.getTipoConta()))
            c.setTipoConta(new TipoConta(dto.getTipoConta())); // TipoConta(tipo)
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
        if (nb(dto.getTelefoneEmergencia()))
            c.setTelefoneEmergencia(new Telefone(dto.getTelefoneEmergencia()));

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
        if (dto.getBanco() != null)
            c.setBanco(nb(dto.getBanco()) ? new Banco(dto.getBanco()) : null);
        if (dto.getAgencia() != null)
            c.setAgencia(nb(dto.getAgencia()) ? new Agencia(dto.getAgencia()) : null);
        if (dto.getConta() != null)
            c.setConta(nb(dto.getConta()) ? new Conta(dto.getConta()) : null);
        if (dto.getTipoConta() != null)
            c.setTipoConta(nb(dto.getTipoConta()) ? new TipoConta(dto.getTipoConta()) : null);
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

        if (dto.getTelefoneEmergencia() != null)
            c.setTelefoneEmergencia(nb(dto.getTelefoneEmergencia()) ? new Telefone(dto.getTelefoneEmergencia()) : null);
    }

    // Converte a entidade em DTO de resposta, extraindo os valores dos VOs
    public CollaboratorResponseDTO toResponse(Collaborator c) {
        return CollaboratorResponseDTO.builder() // Usa builder do DTO de resposta
                .tipoContrato(c.getTipoContrato()) // Copia tipo de contrato
                .salario(c.getSalario()) // Copia salário
                .matricula(c.getMatricula()) // Copia matrícula
                .cargaHoraria(c.getCargaHoraria()) // Copia carga horária
                // Extrai valores primitivos dos VOs bancários
                .banco(c.getBanco() != null ? c.getBanco().getCodigo() : null)
                .agencia(c.getAgencia() != null ? c.getAgencia().getNumero() : null)
                .conta(c.getConta() != null ? c.getConta().getNumero() : null)
                .tipoConta(c.getTipoConta() != null ? c.getTipoConta().getTipo() : null)
                .pix(c.getPix() != null ? c.getPix().getChave() : null)
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
                .telefoneEmergencia(c.getTelefoneEmergencia() != null ? c.getTelefoneEmergencia().getNumero() : null)
                .escolaridade(c.getEscolaridade())
                .curso(c.getCurso())
                .build(); // Finaliza a construção do DTO
    }

    // Helper: verifica se uma String não é nula nem em branco
    private static boolean nb(String s) {
        return s != null && !s.isBlank();
    }
}