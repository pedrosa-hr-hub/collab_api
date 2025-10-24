package com.example.collab.domain.converter;

import com.example.collab.domain.Agencia;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AgenciaConverter implements AttributeConverter<Agencia, String> {

    @Override
    public String convertToDatabaseColumn(Agencia attribute) {
        return attribute != null ? attribute.getNumero() : null;
    }

    @Override
    public Agencia convertToEntityAttribute(String dbData) {
        return dbData != null ? new Agencia(dbData) : null;
    }
}