package com.example.collab.domain;

import lombok.Value;

@Value
public class TituloEleitor {
    String titulo;

    public TituloEleitor(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título de Eleitor deve ser informado");
        }

        // Remove caracteres não numéricos
        String cleanedTitulo = titulo.replaceAll("\\D", "");

        // Valida o tamanho do Título de Eleitor
        if (cleanedTitulo.length() != 12) {
            throw new IllegalArgumentException("Título de Eleitor deve conter 12 dígitos");
        }

        // Valida os dígitos verificadores
        if (!isValidTituloEleitor(cleanedTitulo)) {
            throw new IllegalArgumentException("Título de Eleitor inválido: " + titulo);
        }

        this.titulo = cleanedTitulo;
    }

    private boolean isValidTituloEleitor(String titulo) {
        // Multiplicadores para o primeiro dígito verificador
        int[] weights1 = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3 };
        int sum1 = 0;

        // Calcula o primeiro dígito verificador
        for (int i = 0; i < 10; i++) {
            int digit = Character.getNumericValue(titulo.charAt(i));
            sum1 += digit * weights1[i];
        }
        int remainder1 = sum1 % 11;
        int check1 = remainder1 == 10 ? 0 : remainder1;

        // Multiplicadores para o segundo dígito verificador
        int[] weights2 = { 7, 8, 9, 2, 3, 4, 5, 6, 7, 8, 9 };
        int sum2 = 0;

        // Calcula o segundo dígito verificador
        for (int i = 0; i < 10; i++) {
            int digit = Character.getNumericValue(titulo.charAt(i));
            sum2 += digit * weights2[i];
        }
        sum2 += check1 * weights2[10];
        int remainder2 = sum2 % 11;
        int check2 = remainder2 == 10 ? 0 : remainder2;

        // Compara os dígitos calculados com os informados
        return check1 == Character.getNumericValue(titulo.charAt(10)) &&
                check2 == Character.getNumericValue(titulo.charAt(11));
    }
}