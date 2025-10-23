package com.example.collab.domain.converter;

import com.example.collab.domain.RG;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RgConverter implements AttributeConverter<RG, String> {

    @Override
    public String convertToDatabaseColumn(RG attribute) {
        return attribute != null ? attribute.getRg() : null;
    }

    @Override
    public RG convertToEntityAttribute(String dbData) {
        return dbData != null ? new RG(dbData) : null;
    }
}