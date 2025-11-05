package com.example.collab.domain.model;

import java.sql.Date;

import com.example.collab.domain.valueobject.banking.*;
import com.example.collab.domain.valueobject.contact.*;
import com.example.collab.domain.valueobject.documento.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Collaborator {

    // Informações Pessoais

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Date birthDate;

    @Getter
    @Setter
    private String maritalStatus;

    @Getter
    @Setter
    private String nationality;

    // ------------------------------------------------------------------//

    // Informações de Contato

    @Getter
    @Setter
    private Email email;

    @Getter
    @Setter
    private Phone phone;

    @Getter
    @Setter
    private String endereco;

    // ------------------------------------------------------------------//

    // Informações Profissionais

    @Getter
    @Setter
    private String cargo;

    @Getter
    @Setter
    private String departamento;

    @Getter
    @Setter
    private Date dataAdmissao;

    @Getter
    @Setter
    private String tipoContrato;

    @Getter
    @Setter
    private Double salario;

    @Getter
    @Setter
    private Integer matricula;

    @Getter
    @Setter
    private String cargaHoraria;

    // ------------------------------------------------------------------//

    // Informações Bancárias

    @Getter
    @Setter
    private Bank bank;

    @Getter
    @Setter
    private Agency agency;

    @Getter
    @Setter
    private Account account;

    @Getter
    @Setter
    private TypeAccount typeAccount;

    @Getter
    @Setter
    private PIX pix;

    // ------------------------------------------------------------------//

    // Dcocumentos

    @Getter
    @Setter
    private WorkWallet workWallet;

    @Getter
    @Setter
    private VoterRegistration voterRegistration;

    @Getter
    @Setter
    private String certificadoReservista;

    @Getter
    @Setter
    private PIS PIS;

    @Getter
    @Setter
    private CNH CNH;

    @Getter
    @Setter
    private CPF CPF;

    @Getter
    @Setter
    private RG RG;

    // ------------------------------------------------------------------//

    // Informações de Emergência

    @Getter
    @Setter
    private String contatoEmergencia;

    @Getter
    @Setter
    private Phone phoneEmergency;

    // ------------------------------------------------------------------//

    // Informações Adicionais

    @Getter
    @Setter
    private String escolaridade;

    @Getter
    @Setter
    private String curso;

    @Getter
    @Setter
    private String observacoes;
}
