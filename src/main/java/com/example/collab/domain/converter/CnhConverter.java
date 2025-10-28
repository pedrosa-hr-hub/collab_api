package com.example.collab.domain.converter;

import com.example.collab.domain.valueobject.documento.CNH;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CnhConverter implements AttributeConverter<CNH, String> {

    @Override
    public String convertToDatabaseColumn(CNH attribute) {
        return attribute != null ? attribute.getCnh() : null;
    }

    @Override
    public CNH convertToEntityAttribute(String dbData) {
        return dbData != null ? new CNH(dbData) : null;
    }
}