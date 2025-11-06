package com.example.collab.domain.converter;

import com.example.collab.domain.valueobject.document.CPF;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CpfConverter implements AttributeConverter<CPF, String> {

    @Override
    public String convertToDatabaseColumn(CPF attribute) {
        return attribute != null ? attribute.getCpf() : null;
    }

    @Override
    public CPF convertToEntityAttribute(String dbData) {
        return dbData != null ? new CPF(dbData) : null;
    }
}