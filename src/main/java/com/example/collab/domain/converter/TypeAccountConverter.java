package com.example.collab.domain.converter;

import com.example.collab.domain.valueobject.bancario.TypeAccount;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TypeAccountConverter implements AttributeConverter<TypeAccount, String> {

    @Override
    public String convertToDatabaseColumn(TypeAccount attribute) {
        return attribute != null ? attribute.getType() : null;
    }

    @Override
    public TypeAccount convertToEntityAttribute(String dbData) {
        return dbData != null ? new TypeAccount(dbData) : null;
    }
}