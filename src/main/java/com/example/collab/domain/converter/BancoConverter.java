package com.example.collab.domain.converter;

import com.example.collab.domain.valueobject.bancario.Banco;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BancoConverter implements AttributeConverter<Banco, String> {

    @Override
    public String convertToDatabaseColumn(Banco attribute) {
        return attribute != null ? attribute.getCodigo() : null;
    }

    @Override
    public Banco convertToEntityAttribute(String dbData) {
        return dbData != null ? new Banco(dbData) : null;
    }
}