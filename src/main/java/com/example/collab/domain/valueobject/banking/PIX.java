package com.example.collab.domain.valueobject.banking;

import com.example.collab.domain.valueobject.contato.Email;
import com.example.collab.domain.valueobject.contato.Phone;
import com.example.collab.domain.valueobject.documento.CNPJ;
import com.example.collab.domain.valueobject.documento.CPF;

import lombok.Value;

@Value
public class PIX {

    String chave;

    public PIX(String chave) {

        if (chave == null || chave.isBlank()) {

            throw new IllegalArgumentException("Chave PIX deve ser informada");

        }
        if (!isValidPix(chave)) {

            throw new IllegalArgumentException("Chave PIX inválida");

        }

        this.chave = chave;

    }

    private boolean isValidPix(String chave) {

        // Valida CPF
        if (chave.matches("\\d{11}")) {

            return new CPF(chave).getCpf() != null; // Reutiliza validação de CPF

        }

        // Valida CNPJ
        if (chave.matches("\\d{14}")) {

            return new CNPJ(chave).getCnpj() != null;// Reutiliza validação de CNPJ

        }

        // Valida e-mail
        if (chave.matches("^[\\w-.]+@[\\w-]+\\.[a-z]{2,}$")) {

            return new Email(chave).getEmail() != null; // Reutiliza validação de e-mail

        }

        // Valida telefone
        if (chave.matches("\\+?\\d{1,3}\\d{10,11}")) {

            return new Phone(chave).getNumber() != null; // Reutiliza validação de telefone

        }

        // Valida chave aleatória (UUID)
        return chave.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}");

    }
}