package com.example.collab.domain.valueobject.contato;

import lombok.Value;

@Value
public class Telefone {
    String numero;

    public Telefone(String numero) {
        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("Número de telefone deve ser informado");
        }
        if (!isValidTelefone(numero)) {
            throw new IllegalArgumentException("Número de telefone inválido: " + numero);
        }
        this.numero = numero;
    }

    private boolean isValidTelefone(String numero) {
        // Valida formato nacional: (XX) XXXXX-XXXX ou (XX) XXXX-XXXX
        if (numero.matches("\\(\\d{2}\\) \\d{4,5}-\\d{4}")) {
            return true;
        }
        // Valida formato internacional: +55 XX XXXXX-XXXX
        if (numero.matches("\\+\\d{1,3} \\d{2} \\d{4,5}-\\d{4}")) {
            return true;
        }

        return false;
    }
}