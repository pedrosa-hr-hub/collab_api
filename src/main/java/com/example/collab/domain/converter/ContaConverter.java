package com.example.collab.domain.converter;

import com.example.collab.domain.valueobject.bancario.Conta;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ContaConverter implements AttributeConverter<Conta, String> {

    @Override
    public String convertToDatabaseColumn(Conta attribute) {
        return attribute != null ? attribute.getNumero() : null;
    }

    @Override
    public Conta convertToEntityAttribute(String dbData) {
        return dbData != null ? new Conta(dbData) : null;
    }
}