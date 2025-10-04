package com.example.collab.dto;

import java.sql.Date;

public record CollaboratorDTO(
        String nome,
        Date DataNascimento,
        String EstadoCivil,
        String Nacionalidade,
        String Email,
        String Telefone,
        String Endereco,
        String Cargo,
        String Departamento,
        Date DataAdmissao,
        String TipoContrato,
        Double Salario,
        String Matricula,
        String CargaHoraria,
        String Banco,
        String Agencia,
        String Conta,
        String TipoConta,
        String Pix,
        String CarteiraTrabalho,
        String TituloEleitor,
        String CertificadoReservista,
        String PIS,
        String CNH,
        String CPF,
        String RG,
        String ContatoEmergencia,
        String TelefoneEmergencia,
        String Escolaridade,
        String Curso,
        String Observacoes) {
}
