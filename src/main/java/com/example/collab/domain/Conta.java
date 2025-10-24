package com.example.collab.domain;

import lombok.Value;

@Value
public class Conta {
    String numero;

    public Conta(String numero) {
        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("Número da conta deve ser informado");
        }
        if (!numero.matches("\\d{6,12}(-\\d)?")) {
            throw new IllegalArgumentException(
                    "Conta deve ter entre 6 e 12 dígitos, podendo incluir um dígito verificador (ex.: 123456-7)");
        }
        this.numero = numero;
    }
}