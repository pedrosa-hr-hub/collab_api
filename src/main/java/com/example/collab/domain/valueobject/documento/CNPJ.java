package com.example.collab.domain.valueobject.documento;

import lombok.Value;

@Value
public class CNPJ {
    String cnpj;

    public CNPJ(String cnpj) {
        if (cnpj == null || cnpj.isBlank()) {
            throw new IllegalArgumentException("CNPJ deve ser informado");
        }

        // Remove caracteres não numéricos
        String cleanedCNPJ = cnpj.replaceAll("\\D", "");

        // Valida o tamanho do CNPJ
        if (cleanedCNPJ.length() != 14) {
            throw new IllegalArgumentException("CNPJ deve conter 14 dígitos");
        }

        // Valida os dígitos verificadores
        if (!isValidCNPJ(cleanedCNPJ)) {
            throw new IllegalArgumentException("CNPJ inválido: " + cnpj);
        }

        this.cnpj = cleanedCNPJ;
    }

    private boolean isValidCNPJ(String cnpj) {
        int[] weights1 = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        int[] weights2 = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

        // Cálculo do primeiro dígito verificador
        int sum1 = 0;
        for (int i = 0; i < 12; i++) {
            int digit = Character.getNumericValue(cnpj.charAt(i));
            sum1 += digit * weights1[i];
        }
        int remainder1 = sum1 % 11;
        int check1 = remainder1 < 2 ? 0 : 11 - remainder1;

        // Cálculo do segundo dígito verificador
        int sum2 = 0;
        for (int i = 0; i < 12; i++) {
            int digit = Character.getNumericValue(cnpj.charAt(i));
            sum2 += digit * weights2[i];
        }
        sum2 += check1 * weights2[12];
        int remainder2 = sum2 % 11;
        int check2 = remainder2 < 2 ? 0 : 11 - remainder2;

        // Compara os dígitos calculados com os informados
        return check1 == Character.getNumericValue(cnpj.charAt(12)) &&
                check2 == Character.getNumericValue(cnpj.charAt(13));
    }
}