package com.example.collab.domain.valueobject.bancario;

import lombok.Value;

@Value
public class Agencia {
    String numero;

    public Agencia(String numero) {
        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("Número da agência deve ser informado");
        }
        if (!numero.matches("\\d{4}(-\\d)?")) {
            throw new IllegalArgumentException(
                    "Agência deve ter 4 dígitos, podendo incluir um dígito verificador (ex.: 1234-5)");
        }
        this.numero = numero;
    }
}